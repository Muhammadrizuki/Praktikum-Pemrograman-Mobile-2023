package com.example.networking;

import com.google.gson.annotations.SerializedName;

public class DataResponse2 {
    @SerializedName("data")
    private UserResponse data;
    public UserResponse getData() {
        return data;
    }

}
