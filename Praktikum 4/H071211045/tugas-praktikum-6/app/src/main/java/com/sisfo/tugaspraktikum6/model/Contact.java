package com.sisfo.tugaspraktikum6.model;

<<<<<<< Updated upstream
=======
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

>>>>>>> Stashed changes
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

<<<<<<< Updated upstream
public class Contact {
=======
public class Contact implements Parcelable {
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
    protected Contact(Parcel in) {
        number = in.readString();
        name = in.readString();
        status = in.readString();
        statusDate = in.readString();
        profilePic = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(number);
        parcel.writeString(name);
        parcel.writeString(status);
        parcel.writeString(statusDate);
        parcel.writeString(profilePic);
    }
>>>>>>> Stashed changes
}
