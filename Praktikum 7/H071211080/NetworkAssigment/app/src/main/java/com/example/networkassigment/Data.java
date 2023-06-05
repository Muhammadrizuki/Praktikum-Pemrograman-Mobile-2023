package com.example.networkassigment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("data")

    private List<User> data;

    public List<User> getData() {
        return data;
    }
}
