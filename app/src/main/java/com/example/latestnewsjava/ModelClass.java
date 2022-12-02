package com.example.latestnewsjava;

import com.google.gson.annotations.SerializedName;

public class ModelClass {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("coverImage")
    String coverImage;

    @SerializedName("excerpt")
    String excerpt;

    @SerializedName("time")
    String time;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
    public String getCoverImage() {
        return coverImage;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }
    public String getExcerpt() {
        return excerpt;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
}
