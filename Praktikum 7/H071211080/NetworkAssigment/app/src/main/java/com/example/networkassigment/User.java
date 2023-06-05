package com.example.networkassigment;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")private String id;
    @SerializedName("first_name")private String FirstName;
    @SerializedName("last_name")private String LastName;
    @SerializedName("email")private String email;
    @SerializedName("avatar")private String avatar;


    public User(String profile, String name, String email) {
    }

    public String getId() { return id; }
    public String getFirstName() { return FirstName; }
    public String getLastName() { return LastName; }
    public String getEmail() { return email; }
    public String getAvatarUrl() { return avatar; }
}
