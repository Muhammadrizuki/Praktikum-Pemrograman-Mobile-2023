package com.sisfo.tugaspraktikum6.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("status_date")
    @Expose
    private String statusDate;

    @SerializedName("profile_pic")
    @Expose
    private String profilePic;

    public Contact(String number, String name, String status, String statusDate, String profilePic) {
        this.number = number;
        this.name = name;
        this.status = status;
        this.statusDate = statusDate;
        this.profilePic = profilePic;
    }

    public String getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public String getProfilePicture() {
        return profilePic;
    }

}
