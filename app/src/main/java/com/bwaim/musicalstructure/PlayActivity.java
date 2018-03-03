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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

    private Album selectedAlbum;
    private Artist selectedArtist;
    private ArrayList<Song> songs;
    private Song currentSong;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // Get all the necessary views
        elapsedTimeTV = findViewById(R.id.elapsedTime);
        remainingTimeTV = findViewById(R.id.remainingTime);

        Intent intent = getIntent();
        selectedAlbum = (Album) intent.getSerializableExtra(MainActivity.SELECTED_ALBUM);
        selectedArtist = (Artist) intent.getSerializableExtra(MainActivity.SELECTED_ARTIST);

        // We get all the songs to be played
        if (selectedAlbum != null) {
            songs = selectedAlbum.getSongs();
        } else if (selectedArtist != null) {
            songs = new ArrayList<>();

            for (Album album : selectedArtist.getAlbums()) {
                songs.addAll(album.getSongs());
            }
        }

        final ListView list = findViewById(R.id.list);
        SongAdapter songAdapter = new SongAdapter(this, songs);
        list.setAdapter(songAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectSong((Song) list.getItemAtPosition(position));
            }
        });

        selectSong((Song) list.getItemAtPosition(0));

    }

    /**
     * Init a countDownTimer for the duration of the selected song
     *
     * @param duration in millisecond
     * @return the countDownTimer
     */
    private CountDownTimer initCountDownTimer(final long duration) {

        return new CountDownTimer(duration, TIMER_INTERVAL) {

            public void onTick(long millisUntilFinished) {
                // Display the remaining time of the song
                long minutes = millisUntilFinished / 1000 / 60;
                remainingTimeTV.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes,
                        (millisUntilFinished - (minutes * 60 * 1000)) / 1000));

                // Display the elapsed time of the song
                long elapsedTime = currentSong.getDuration() - (millisUntilFinished / TIMER_INTERVAL);
                minutes = elapsedTime / 60;
                elapsedTimeTV.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes,
                        (elapsedTime - (minutes * 60))));
            }

            public void onFinish() {
                //TODO
            }
        };
    }

    private void selectSong(Song selection) {
        currentSong = selection;

        // initialization of the elapsed time of the current song
        long durationMS = selection.getDuration() * TIMER_INTERVAL;
        countDownTimer = initCountDownTimer(durationMS);
        countDownTimer.onTick(durationMS);
    }
}
