/*
 *    Copyright 2018 Fabien Boismoreau
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.bwaim.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bwaim.musicalstructure.Model.Album;
import com.bwaim.musicalstructure.Model.Artist;
import com.bwaim.musicalstructure.Model.Song;

import java.util.ArrayList;
import java.util.Locale;

public class PlayActivity extends AppCompatActivity {

    // Interval to refresh the countDownTimer in milliseconds
    private final long TIMER_INTERVAL = 1000;

    private TextView elapsedTimeTV;
    private TextView remainingTimeTV;
    private ImageView coverIV;
    private ListView listLV;
    private ImageView playStopIV;
    private SeekBar seekBar;
    private ImageView nextIconIV;
    private ImageView previousIconIV;
    private ImageView replayIV;

    private Album selectedAlbum;
    private Artist selectedArtist;
    private ArrayList<Song> songs;
    private Song currentSong;
    private boolean isPlaying;
    private long remainingTime;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Get all the necessary views
        elapsedTimeTV = findViewById(R.id.elapsedTime);
        remainingTimeTV = findViewById(R.id.remainingTime);
        coverIV = findViewById(R.id.cover);
        playStopIV = findViewById(R.id.playStopIcon);
        seekBar = findViewById(R.id.seekBar);
        nextIconIV = findViewById(R.id.nextIcon);
        previousIconIV = findViewById(R.id.previousIcon);
        replayIV = findViewById(R.id.replayIcon);

        // Get the information from the intent
        Intent intent = getIntent();
        selectedAlbum = (Album) intent.getSerializableExtra(MainActivity.SELECTED_ALBUM);
        selectedArtist = (Artist) intent.getSerializableExtra(MainActivity.SELECTED_ARTIST);

        // Init variables
        currentSong = null;
        isPlaying = false;
        countDownTimer = initCountDownTimer(0);

        // Get all the songs to be played, depending if we have an album or an artist
        if (selectedAlbum != null) {
            songs = selectedAlbum.getSongs();

            setTitle(selectedAlbum.getName());

            coverIV.setImageResource(getResources().getIdentifier(
                    selectedAlbum.getCover(), "drawable", getPackageName()));
        } else if (selectedArtist != null) {
            songs = new ArrayList<>();

            for (Album album : selectedArtist.getAlbums()) {
                songs.addAll(album.getSongs());
            }

            setTitle(selectedArtist.getName());

            coverIV.setImageResource(getResources().getIdentifier(
                    selectedArtist.getPhoto(), "drawable", getPackageName()));
        }

        // Fill the list of songs
        listLV = findViewById(R.id.list);
        SongAdapter songAdapter = new SongAdapter(this, songs);
        listLV.setAdapter(songAdapter);
        listLV.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        selectSong((Song) listLV.getItemAtPosition(0));

        // Set the listeners
        listLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectSong((Song) parent.getItemAtPosition(position));
                view.setSelected(true);
            }
        });

        playStopIV.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                playPause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * Notification that the progress level has changed. Clients can use the fromUser parameter
             * to distinguish user-initiated changes from those that occurred programmatically.
             *
             * @param seekBar  The SeekBar whose progress has changed
             * @param progress The current progress level.
             * @param fromUser True if the progress change was initiated by the user.
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                remainingTime = (currentSong.getDuration() - seekBar.getProgress())
                        * TIMER_INTERVAL;
                refreshTime();

            }

            /**
             * Notification that the user has started a touch gesture. Clients may want to use this
             * to disable advancing the seekbar.
             *
             * @param seekBar The SeekBar in which the touch gesture began
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                countDownTimer.cancel();
            }

            /**
             * Notification that the user has finished a touch gesture. Clients may want to use this
             * to re-enable advancing the seekbar.
             *
             * @param seekBar The SeekBar in which the touch gesture began
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                countDownTimer = initCountDownTimer((currentSong.getDuration() -
                        seekBar.getProgress()) * TIMER_INTERVAL);
                countDownTimer.onTick(remainingTime);
                if (isPlaying) {
                    countDownTimer.start();
                }
            }
        });

        nextIconIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextSong();
            }
        });

        previousIconIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousSong();
            }
        });

        replayIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSong(currentSong);
            }
        });

    }

    /**
     * Init a countDownTimer for the duration of the selected song
     *
     * @param duration in millisecond
     * @return the countDownTimer
     */
    private CountDownTimer initCountDownTimer(final long duration) {

        remainingTime = duration;

        return new CountDownTimer(duration, TIMER_INTERVAL) {

            public void onTick(long millisUntilFinished) {
                remainingTime = millisUntilFinished;

                refreshTime();

                // Update the seekBar
                seekBar.setProgress(currentSong.getDuration() - (int) (millisUntilFinished / TIMER_INTERVAL));
            }

            public void onFinish() {
                nextSong();
            }
        };
    }

    /**
     * Refresh the display of the time
     */
    private void refreshTime() {
        // Display the remaining time of the song
        long minutes = remainingTime / 1000 / 60;
        remainingTimeTV.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes,
                (remainingTime - (minutes * 60 * 1000)) / 1000));

        // Display the elapsed time of the song
        long elapsedTime = currentSong.getDuration() - (remainingTime / 1000);
        minutes = elapsedTime / 60;
        elapsedTimeTV.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes,
                (elapsedTime - (minutes * 60))));
    }

    /**
     * Select the song to play
     *
     * @param selection the selected song
     */
    private void selectSong(Song selection) {
        currentSong = selection;

        countDownTimer.cancel();

        // initialization of the elapsed time of the current song
        long durationMS = selection.getDuration() * TIMER_INTERVAL;
        countDownTimer = initCountDownTimer(durationMS);
        countDownTimer.onTick(durationMS);

        // initialization of the seekBar
        seekBar.setMax(selection.getDuration());
        seekBar.setProgress(0);

        if (isPlaying) {
            countDownTimer.start();
        }
    }

    /**
     * Play or pause the current song
     */
    private void playPause() {

        if (isPlaying) {
            playStopIV.setImageResource(R.drawable.ic_play_circle_filled);
            countDownTimer.cancel();
        } else {
            playStopIV.setImageResource(R.drawable.ic_pause_circle_filled);
            countDownTimer = initCountDownTimer(remainingTime);
            countDownTimer.start();
        }

        isPlaying = !isPlaying;
    }

    /**
     * Select the next song
     */
    private void nextSong() {
        int currentPosition = songs.indexOf(currentSong);

        // Deselect the current item
        int firstDisplayedPosition = listLV.getFirstVisiblePosition();
        listLV.getChildAt(currentPosition - firstDisplayedPosition).setSelected(false);

        currentPosition++;
        // When we are at the bottom, we go back to the top
        if (currentPosition == songs.size()) {
            currentPosition = 0;
            firstDisplayedPosition = 0;
            listLV.setSelectionAfterHeaderView();
        }

        selectSong((Song) listLV.getItemAtPosition(currentPosition));

        listLV.getChildAt(currentPosition - firstDisplayedPosition).setSelected(true);
        listLV.smoothScrollToPosition(currentPosition + 5 - firstDisplayedPosition);
    }

    /**
     * Select the previous song
     */
    private void previousSong() {
        int currentPosition = songs.indexOf(currentSong);

        // Deselect the current item
        int firstDisplayedPosition = listLV.getFirstVisiblePosition();
        listLV.getChildAt(currentPosition - firstDisplayedPosition).setSelected(false);

        currentPosition--;
        // When we are at the top, we go to the bottom of the list
        if (currentPosition == -1) {
            currentPosition = songs.size() - 1;
            listLV.smoothScrollToPosition(currentPosition);
            firstDisplayedPosition = listLV.getFirstVisiblePosition();
        }

        selectSong((Song) listLV.getItemAtPosition(currentPosition));

        // Trick because when going too the last element of the list, the View item doesn't exists
        if (currentPosition <= listLV.getLastVisiblePosition()) {
            listLV.getChildAt(currentPosition - firstDisplayedPosition).setSelected(true);
            listLV.smoothScrollToPosition(currentPosition - 2 - firstDisplayedPosition);
        }
    }

}
