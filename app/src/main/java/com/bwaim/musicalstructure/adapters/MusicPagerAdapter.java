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

package com.bwaim.musicalstructure.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bwaim.musicalstructure.ui.AlbumFragment;
import com.bwaim.musicalstructure.ui.ArtistFragment;

/**
 * Created by Fabien Boismoreau on 25/02/2018.
 * <p>The PageAdapter needed by the ViewPager
 */

public class MusicPagerAdapter extends FragmentPagerAdapter {

    public static final int M_NB_VIEWS = 2;
    private String[] pageTitles;

    public MusicPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return M_NB_VIEWS;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position to display
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AlbumFragment.newInstance();
            case 1:
                return ArtistFragment.newInstance();
        }
        throw new IllegalStateException();
    }

    public void setPageTitles(String[] pageTitles) {
        this.pageTitles = pageTitles;
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position < M_NB_VIEWS) {
            return pageTitles[position];
        }
        return null;
    }
}
