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


public class List {

    /** String resource ID for the Title*/
    private int mTitleId;

    /** String resource ID for the Description */
    private int mDescriptionId;

    
    /** Image resource ID */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mEmojiResourceId = NO_IMAGE_PROVIDED;

    /** URL resource ID */
    //private int mEmojiResourceId;

    /** Constant value that represents no image was provided for this item */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Item object.
     *
     * @param titleId is the string resource ID for the title
     * @param descriptionId is the string resource Id for description
     //* @param urlId is the string resource for the URL
     */
    public List(int titleId,  int descriptionId, int imageResourceId, int emojiResourceId) {
        mTitleId = titleId;
        mDescriptionId = descriptionId;
        mImageResourceId = imageResourceId;
        mEmojiResourceId = emojiResourceId;
        
    }

    /**
     * Create a new List object.
     *
     * @param titleId is the string resource ID for the title
     * @param descriptionId is the string resource Id for description
     //* @param urlId is the string resource for the URL
     * @param imageResourceId is the drawable resource ID for the image associated with the item
     * 
     */
    public List(int titleId, int descriptionId, int imageResourceId) {
        mTitleId = titleId;
        mDescriptionId = descriptionId;
        //mUrlResourceId = urlId;
        mImageResourceId = imageResourceId;

        
    }

    /**
     * Get the string resource ID for the title.
     */
    public int getTitleId() {
        return mTitleId;
    }

    /**
     * Get the string resource ID for the description.
     */
    public int getDescriptionId() {
        return mDescriptionId;
    }

    /**
     * Get the string resource ID for the url.
     */
    public int getEmojiResourceIdId() { return mEmojiResourceId; }

    /**
     * Return the image resource ID of the item.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this item.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns whether or not there is an image for this item.
     */
    public boolean hasEmoji() {
        return mEmojiResourceId != NO_IMAGE_PROVIDED;
    }

    
}