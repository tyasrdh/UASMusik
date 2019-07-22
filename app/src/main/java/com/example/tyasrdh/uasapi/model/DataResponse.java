package com.example.tyasrdh.uasapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("data")
    @Expose

    private List<Musik> data = null;

    public List<Musik> getData() {

        return data;

    }

    public void setData(List<Musik> data) {

        this.data = data;

    }
}
