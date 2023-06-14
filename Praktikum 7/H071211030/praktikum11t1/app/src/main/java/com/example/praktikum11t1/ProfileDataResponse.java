package com.example.praktikum11t1;

import com.google.gson.annotations.SerializedName;

public class ProfileDataResponse {

    @SerializedName("data")
    private UserResponse data;

    public UserResponse getDataProfile() {
        return data;
    }
}
