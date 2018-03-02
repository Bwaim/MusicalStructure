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
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bwaim.musicalstructure.Model.Album;
import com.bwaim.musicalstructure.Model.Artist;
import com.bwaim.musicalstructure.Model.Song;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    private Album selectedAlbum;
    private Artist selectedArtist;
    private ArrayList<Song> songs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

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

        ListView list = findViewById(R.id.list);
        SongAdapter aongAdapter = new SongAdapter(this, songs);
        list.setAdapter(aongAdapter);

    }
}
