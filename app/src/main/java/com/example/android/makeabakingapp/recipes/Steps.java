package com.example.android.makeabakingapp.recipes;

import org.parceler.Parcel;

/**
 * Created by thais.nonato on 3/12/2018.
 */
@Parcel
public class Steps {

    int id;
    String shortDescription;
    String description;
    String videoURL;
    String thumbnailURL;

    public Steps() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;


    }

}