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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Fabien Boismoreau on 25/02/2018.
 * <p>The PageAdapter needed by the ViewPager
 */

public class MusicPagerAdapter extends FragmentPagerAdapter {

    private static final int M_NB_VIEWS = 2;

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
    @Override
    public Fragment getItem(int position) {
        return null;
    }
}
