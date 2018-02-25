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

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bwaim.musicalstructure.Model.Album;

import java.util.List;

public class AlbumAdapter extends ArrayAdapter<Album> {

    /**
     * Constructor
     *
     * @param context The current context.
     * @param albums  The objects to represent in the ListView.
     */
    AlbumAdapter(@NonNull Context context, @NonNull List<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_album_item, parent, false);
        }

        Album currentAlbum = getItem(position);

        if (currentAlbum != null) {
            TextView name = listItemView.findViewById(R.id.name);
            name.setText(currentAlbum.getName());

            TextView artist = listItemView.findViewById(R.id.artist);
            artist.setText(currentAlbum.getArtist());
        }

        return listItemView;
    }
}