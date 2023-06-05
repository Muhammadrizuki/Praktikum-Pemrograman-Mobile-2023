package com.example.networkassigment;

import com.google.gson.annotations.SerializedName;

public class Data2 {
    @SerializedName("data") private User data;

    public User getData() {
        return data;
    }
}
