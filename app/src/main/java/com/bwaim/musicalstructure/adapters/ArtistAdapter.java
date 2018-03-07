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

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwaim.musicalstructure.R;
import com.bwaim.musicalstructure.model.Artist;

import java.util.List;

/**
 * Created by Fabien Boismoreau on 27/02/2018.
 * <p>
 */

public class ArtistAdapter extends ArrayAdapter<Artist> {

    /**
     * Constructor
     *
     * @param context The current context.
     * @param artists The objects to represent in the ListView.
     */
    public ArtistAdapter(@NonNull Context context, @NonNull List<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_artist_item, parent, false);
        }

        Artist currentArtist = getItem(position);

        if (currentArtist != null) {
            ImageView photoIV = listItemView.findViewById(R.id.photo_image_view);
            photoIV.setImageResource(getContext().getResources().getIdentifier(
                    currentArtist.getPhoto(), "drawable", getContext().getPackageName()));

            TextView nameTV = listItemView.findViewById(R.id.name_text_view);
            nameTV.setText(currentArtist.getName());
        }

        return listItemView;
    }
}
