/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package josemarq.elprattourguideapp;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.duration;
import static android.media.CamcorderProfile.get;
import static android.os.Build.VERSION_CODES.M;

/**
 * {@link Fragment} that displays a list of number vocabulary words.
 */
public class PlayaFragment extends Fragment {


    public PlayaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        // Create a list of lists
        final ArrayList<List> lists = new ArrayList<List>();
        lists.add(new List(R.string.playa1, R.string.descripcionplaya1, R.drawable.img_vela));
        lists.add(new List(R.string.playa2, R.string.descripcionplaya2, R.drawable.img_cram));
        lists.add(new List(R.string.playa3, R.string.descripcionplaya3, R.drawable.img_pineda));
        lists.add(new List(R.string.playa4, R.string.descripcionplaya4, R.drawable.img_illa));
        lists.add(new List(R.string.playa5, R.string.descripcionplaya5, R.drawable.img_avions));


        // Create an {@link ListAdapter}, whose data source is a list of {@link List}s. The
        // adapter knows how to create list items for each item in the list.
        ListAdapter adapter = new ListAdapter(getActivity(), lists, R.color.color_white);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ListAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link List} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                List list = lists.get(position);

                int imagen = list.getImageResourceId();

                // On click row open DetailsActivity and pass the data
                Intent i = new Intent(getActivity(), DetailsActivity.class);
                i.putExtra("Title", getResources().getString(list.getTitleId()));
                i.putExtra("Description", getResources().getString(list.getDescriptionId()));
                i.putExtra("Imagen", imagen);
                startActivity(i);

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
