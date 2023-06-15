package com.example.tuprak7;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("data")
    private List<UserResponse> user;
    public List<UserResponse> getUsers() {
        return user;
    }
}
