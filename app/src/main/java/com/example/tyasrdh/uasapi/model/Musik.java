package com.example.tyasrdh.uasapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Musik {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("musik_title")
    @Expose
    private String musik_title;

    @SerializedName("musik_genre")
    @Expose
    private String musik_genre;

    @SerializedName("awards")
    @Expose
    private String awards;

    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("singer")
    @Expose
    private String singer;

    @SerializedName("release_year")
    @Expose
    private String release_year;

    @SerializedName("musik_writer")
    @Expose
    private String musik_writer;


    public Musik(Integer id, String musik_title, String musik_genre, String awards, String label, String singer, String release_year, String musik_writer) {
        this.id = id;
        this.musik_title = musik_title;
        this. musik_genre = musik_genre;
        this. awards = awards;
        this.label = label;
        this.singer = singer;
        this.release_year = release_year;
        this.musik_writer = musik_writer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusik_title() {
        return musik_title;
    }
    public void setMusik_title(String musik_title) {
        this.musik_title = musik_title;
    }

    public String getMusik_genre() {
        return musik_genre;
    }
    public void setMusik_genre(String musik_genre) {
        this.musik_genre = musik_genre;
    }

    public String getAwards() {
        return awards;
    }
    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getRelease_year() {
        return release_year;
    }
    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getMusik_writer() {
        return musik_writer;
    }
    public void setMusik_writer(String musik_writer) {
        this.musik_writer = musik_writer;
    }
}
