package com.example.tugasmobile7;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("id") private String id;
    @SerializedName("first_name") private String firstName;
    @SerializedName("last_name") private String lastName;
    @SerializedName("email") private String email;
    @SerializedName("avatar") private String avatarUrl;

    public UserResponse(String profile, String name, String email) {
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getAvatarUrl() { return avatarUrl; }
}