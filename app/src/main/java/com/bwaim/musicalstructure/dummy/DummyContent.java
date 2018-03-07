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

import com.bwaim.musicalstructure.model.Album;
import com.bwaim.musicalstructure.model.Artist;
import com.bwaim.musicalstructure.model.Song;

import java.util.ArrayList;
import java.util.List;

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

    private static final int COUNT = 1;

    static {

        Artist monLaferte = new Artist("Mon Laferte", "mon_laferte");
        Artist julienDore = new Artist("Julien Doré", "julien_dore");
        Artist moby = new Artist("Moby", "moby");
        Artist edSheeran = new Artist("Ed Sheeran", "ed_sheeran");
        Artist louane = new Artist("Louane", "louane_artist");
        Artist stromae = new Artist("Stromae", "stromae");
        Artist florentPagny = new Artist("Florent Pagny", "florent_pagny");

        // Add some sample items.
        Album monLaferteVol1 = new Album("Mon Laferte, Vol 1", monLaferte, "mon_laferte_vol_1");
        monLaferteVol1.addSong(new Song("Tormento", 276));
        monLaferteVol1.addSong(new Song("El Cristal", 180));
        monLaferteVol1.addSong(new Song("El Diablo", 242));
        monLaferteVol1.addSong(new Song("La Visista", 226));
        monLaferteVol1.addSong(new Song("Amor Completo", 241));
        monLaferteVol1.addSong(new Song("Un Alma en Pena", 142));
        monLaferteVol1.addSong(new Song("Tu Falta de Querer", 278, "mon_laferte_tu_falta_de_querer"));
        monLaferteVol1.addSong(new Song("Salvador", 200));
        monLaferteVol1.addSong(new Song("Si Tu Me Quisieras", 202));
        monLaferteVol1.addSong(new Song("Malagradecido", 187));
        monLaferteVol1.addSong(new Song("La Noche del Dia Que Llovio en Verano", 56));

        Album laTrenza = new Album("La Trenza", monLaferte, "la_trenza");
        laTrenza.addSong(new Song("Pa Donde Se Fue", 249));
        laTrenza.addSong(new Song("Que Si", 203));
        laTrenza.addSong(new Song("Mi Buen Amor", 227));
        laTrenza.addSong(new Song("Ana", 165));
        laTrenza.addSong(new Song("Amarrame", 207));
        laTrenza.addSong(new Song("Yo Te Qui", 166));
        laTrenza.addSong(new Song("Primaveral", 231));
        laTrenza.addSong(new Song("No Te Fumes Mi Mariguana", 270));
        laTrenza.addSong(new Song("Cielito De Abril", 174));
        laTrenza.addSong(new Song("Flaco", 256));
        laTrenza.addSong(new Song("La Trenza", 228));

        Album vousEtMoi = new Album("Vous & moi", julienDore, "vous_et_moi");
        vousEtMoi.addSong(new Song("Le Lac", 259));
        vousEtMoi.addSong(new Song("Coco Câline", 226));
        vousEtMoi.addSong(new Song("porto-Vecchio", 261));
        vousEtMoi.addSong(new Song("Moonlight Serenade", 232));
        vousEtMoi.addSong(new Song("Africa", 212));
        vousEtMoi.addSong(new Song("Eden", 249));
        vousEtMoi.addSong(new Song("Sublime & silence", 293));
        vousEtMoi.addSong(new Song("Romy", 256));
        vousEtMoi.addSong(new Song("Caresse", 254));
        vousEtMoi.addSong(new Song("Magnolia", 276));
        vousEtMoi.addSong(new Song("Se mes sombres archives", 616));
        vousEtMoi.addSong(new Song("Aline", 226));

        Album everyThingWasBeautiful = new Album("Everything Was Beautiful, And Nothing Hurt"
                , moby, "every_thing_was_beautiful");
        everyThingWasBeautiful.addSong(new Song("Mere Anarchy", 315));
        everyThingWasBeautiful.addSong(new Song("The Waste of Suns", 284));
        everyThingWasBeautiful.addSong(new Song("like a Motherless Child", 277));
        everyThingWasBeautiful.addSong(new Song("The Last of Goodbyes", 263));
        everyThingWasBeautiful.addSong(new Song("The Ceremony of innocence", 236));
        everyThingWasBeautiful.addSong(new Song("The Tired and the Hurt", 268));
        everyThingWasBeautiful.addSong(new Song("Welcome to Hard Times", 308));
        everyThingWasBeautiful.addSong(new Song("The Sorrow Tree", 268));
        everyThingWasBeautiful.addSong(new Song("Falling Rain and Light", 286));
        everyThingWasBeautiful.addSong(new Song("The Middle is Gone", 313));
        everyThingWasBeautiful.addSong(new Song("The Wild Darkness", 249));
        everyThingWasBeautiful.addSong(new Song("A Dark Cloud is Coming", 324));

        Album divide = new Album("Divide", edSheeran, "divide");
        divide.addSong(new Song("Eraser", 227));
        divide.addSong(new Song("Castle on the Hill", 261));
        divide.addSong(new Song("Dive", 238));
        divide.addSong(new Song("Shape of You", 237));
        divide.addSong(new Song("Perfect", 263));
        divide.addSong(new Song("Galway Girl", 170));
        divide.addSong(new Song("Happier", 207));
        divide.addSong(new Song("New Man", 189));
        divide.addSong(new Song("Hearts Don't Break Around Here", 248));
        divide.addSong(new Song("What Do I Know ?", 237));
        divide.addSong(new Song("How Would You Fell", 280));
        divide.addSong(new Song("Supermarket Flowers", 221));
        divide.addSong(new Song("Barcelona", 191));
        divide.addSong(new Song("Bibia Be Ye Ye", 176));
        divide.addSong(new Song("Nancy Mulligan", 179));
        divide.addSong(new Song("Save Myself", 247));

        Album louaneAlbum = new Album("Louane", louane, "louane");
        louaneAlbum.addSong(new Song("Non-sens", 183));
        louaneAlbum.addSong(new Song("On était beau", 205));
        louaneAlbum.addSong(new Song("Sans arrêt", 186));
        louaneAlbum.addSong(new Song("Si t'étais là", 153));
        louaneAlbum.addSong(new Song("Midi sur novembre", 199));
        louaneAlbum.addSong(new Song("No", 208));
        louaneAlbum.addSong(new Song("Ecchymoses", 172));
        louaneAlbum.addSong(new Song("Immobile", 179));
        louaneAlbum.addSong(new Song("Nuit pourpre", 239));
        louaneAlbum.addSong(new Song("When We Go Home", 166));
        louaneAlbum.addSong(new Song("Pour oublier l'amour", 207));
        louaneAlbum.addSong(new Song("Blonde", 197));
        louaneAlbum.addSong(new Song("Lego", 219));
        louaneAlbum.addSong(new Song("Jour de pluie", 179));
        louaneAlbum.addSong(new Song("it Won't Kill Ya", 217));

        Album racineCarree = new Album("Racine carrée", stromae, "racine_carre");
        racineCarree.addSong(new Song("Ta fête", 176));
        racineCarree.addSong(new Song("Papaoutai", 232));
        racineCarree.addSong(new Song("Bâtard", 208));
        racineCarree.addSong(new Song("Ave Cesaria", 249));
        racineCarree.addSong(new Song("Tous les mêmes", 213));
        racineCarree.addSong(new Song("Formidable", 213));
        racineCarree.addSong(new Song("Moules frites", 158));
        racineCarree.addSong(new Song("Carmen", 189));
        racineCarree.addSong(new Song("Humain à l'eau", 239));
        racineCarree.addSong(new Song("Quand c'est?", 180));
        racineCarree.addSong(new Song("Sommeil", 218));
        racineCarree.addSong(new Song("Merci", 234));
        racineCarree.addSong(new Song("Avf", 224));

        Album lePresentDabord = new Album("Le présent d'abord", florentPagny, "le_present_d_abord");
        lePresentDabord.addSong(new Song("Le présent d'abord", 213));
        lePresentDabord.addSong(new Song("La beauté du doute", 233));
        lePresentDabord.addSong(new Song("Je veux en voir encore", 176));
        lePresentDabord.addSong(new Song("Je connais personne", 230));
        lePresentDabord.addSong(new Song("interlude \"l'âge de raison\"", 44));
        lePresentDabord.addSong(new Song("L'âge de raison", 233));
        lePresentDabord.addSong(new Song("C'est peut-être", 198));
        lePresentDabord.addSong(new Song("Entre mes lignes", 242));
        lePresentDabord.addSong(new Song("Interlude \"Gandhi\"", 26));
        lePresentDabord.addSong(new Song("Gandhi", 221));
        lePresentDabord.addSong(new Song("Immense", 216));
        lePresentDabord.addSong(new Song("Dessine", 216));

        monLaferte.addAlbum(monLaferteVol1);
        monLaferte.addAlbum(laTrenza);
        julienDore.addAlbum(vousEtMoi);
        moby.addAlbum(everyThingWasBeautiful);
        edSheeran.addAlbum(divide);
        louane.addAlbum(louaneAlbum);
        stromae.addAlbum(racineCarree);
        florentPagny.addAlbum(lePresentDabord);

        for (int i = 1; i <= COUNT; i++) {
            addItem(monLaferteVol1, monLaferte);
            addItem(laTrenza, null);
            addItem(vousEtMoi, julienDore);
            addItem(everyThingWasBeautiful, moby);
            addItem(divide, edSheeran);
            addItem(louaneAlbum, louane);
            addItem(racineCarree, stromae);
            addItem(lePresentDabord, florentPagny);
        }
    }

    private static void addItem(Album item, Artist artist) {
        ITEMS_ALBUMS.add(item);
        if (artist != null) {
            ITEMS_ARTISTS.add(artist);
        }
    }
}
