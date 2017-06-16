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

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * {@link ListAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link List} objects.
 */
public class ListAdapter extends ArrayAdapter<List>  {

    /** Resource ID for the background color for this list of items */
    private int mColorResourceId;

    /**
     * Create a new {@link ListAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param lists is the list of {@link List}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of lists
     */
    public ListAdapter(Context context, ArrayList<List> lists, int colorResourceId) {
        super(context, 0, lists);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        // Get the {@link List} object located at this position in the list
        List currentList = getItem(position);

        // Find the TextView in the item_list.xml layout with the ID Title.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        titleTextView.setText(currentList.getTitleId());

        // Find the TextView in the item_list.xml layout with the ID Description.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        descriptionTextView.setText(currentList.getDescriptionId());

        TextView emojiTextView = (TextView) listItemView.findViewById(R.id.emoji);


        //Check if there are an emoji an show the emoji TextView and not the Description (on list)
        if (currentList.hasEmoji()) {
            emojiTextView.setText(currentList.getEmojiResourceIdId());
            descriptionTextView.setVisibility(View.GONE);
            emojiTextView.setVisibility(View.VISIBLE);
        } else {
            descriptionTextView.setVisibility(View.VISIBLE);
            emojiTextView.setVisibility(View.GONE);
        }

        // Find the ImageView in the item_list.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this item or not

        if (currentList.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentList.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in the ListView.
        return listItemView;
    }
}