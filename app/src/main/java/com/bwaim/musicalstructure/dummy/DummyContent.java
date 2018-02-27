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

package com.bwaim.musicalstructure.dummy;

import com.bwaim.musicalstructure.Model.Album;
import com.bwaim.musicalstructure.Model.Artist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Album> ITEMS_ALBUMS = new ArrayList<>();
    public static final List<Artist> ITEMS_ARTISTS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Album> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 25;

    static {

        Artist artist = new Artist("Mon Laferte", "mon_laferte");

        // Add some sample items.
        Album album = new Album("Mon Laferte, Vol 1", artist, "mon_laferte_vol_1");
        album.addSong("Tormento");
        album.addSong("El Cristal");
        album.addSong("El Diablo");
        album.addSong("La Visista");
        album.addSong("Amor Completo");
        album.addSong("Un Alma en Pena");
        album.addSong("Tu Falta de Querer");
        album.addSong("Salvador");
        album.addSong("Si Tu Me Quisieras");
        album.addSong("Malagradecido");
        album.addSong("La Noche del Dia Que Llovio en Verano");

        artist.addAlbum(album);

        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
            addItem(album, artist);
        }
    }

    private static void addItem(Album item, Artist artist) {
        ITEMS_ALBUMS.add(item);
        ITEMS_ARTISTS.add(artist);
//        ITEM_MAP.put(item.id, item);
    }

    @SuppressWarnings("unused")
    private static Album createDummyItem(int position) {
        return new Album("Name " + position,
                new Artist("Artist " + position, "mon_laferte"),
                "mon_laferte_vol_1");
    }

    @SuppressWarnings("unused")
    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
