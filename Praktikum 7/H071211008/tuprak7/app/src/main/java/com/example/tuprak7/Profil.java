package com.example.tuprak7;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Profil {
    @SerializedName("data")
    private UserResponse profil;

    public UserResponse getProfil() {
        return profil;
    }
}
