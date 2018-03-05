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
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.bwaim.musicalstructure.Model.Album;
import com.bwaim.musicalstructure.Model.Artist;

public class MainActivity extends AppCompatActivity
        implements AlbumFragment.OnAlbumSelectedListener, ArtistFragment.OnArtistSelectedListener {

    public static final String SELECTED_ALBUM = "SELECTED_ALBUM";
    public static final String SELECTED_ARTIST = "SELECTED_ARTIST";

    private MusicPagerAdapter musicPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To remove the shadow
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }

        // Create the tabs
        musicPagerAdapter = new MusicPagerAdapter(getSupportFragmentManager());
        musicPagerAdapter.setPageTitles(initPagesTitles());

        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(musicPagerAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private String[] initPagesTitles() {
        String[] pageTitles = new String[MusicPagerAdapter.M_NB_VIEWS];
        pageTitles[0] = getResources().getString(R.string.albums);
        pageTitles[1] = getResources().getString(R.string.artists);
        return pageTitles;
    }

    @Override
    public void onAlbumSelected(Album album) {
        Intent playActivity = new Intent(MainActivity.this, PlayActivity.class);
        playActivity.putExtra(SELECTED_ALBUM, album);
        startActivity(playActivity);
    }

    @Override
    public void onArtistSelected(Artist artist) {
        Intent playActivity = new Intent(MainActivity.this, PlayActivity.class);
        playActivity.putExtra(SELECTED_ARTIST, artist);
        startActivity(playActivity);
    }
}
