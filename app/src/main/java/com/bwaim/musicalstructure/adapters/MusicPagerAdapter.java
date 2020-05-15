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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.bwaim.musicalstructure.ui.AlbumFragment;
import com.bwaim.musicalstructure.ui.ArtistFragment;

/**
 * Created by Fabien Boismoreau on 25/02/2018.
 * <p>The PageAdapter needed by the ViewPager
 */

public class MusicPagerAdapter extends FragmentStateAdapter {

    public static final int M_NB_VIEWS = 2;

    public MusicPagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getItemCount() {
        return M_NB_VIEWS;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position to display
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return AlbumFragment.newInstance();
            case 1:
                return ArtistFragment.newInstance();
        }
        throw new IllegalStateException();
    }
}
