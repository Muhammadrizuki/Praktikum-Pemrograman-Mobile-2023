package com.sisfo.tugaspraktikum4.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

    public String fullName, username, description;
    public Uri profilePicture, postPicture;

    public User(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
    }

    public User() {/* Empty Constructor */}

    /* Parcelable Implementation */
    protected User(Parcel in) {
        fullName = in.readString();
        username = in.readString();
        description = in.readString();
        profilePicture = in.readParcelable(Uri.class.getClassLoader());
        postPicture = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    /* End of Parcelable Implementation */

    public void setProfilePicture(Uri profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setPostPicture(Uri postPicture) {
        this.postPicture = postPicture;
    }

    public void setPostDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPostDescription() {
        return this.description;
    }

    public Uri getProfilePicture() {
        return this.profilePicture;
    }

    public Uri getPostPicture() {
        return this.postPicture;
    }

    /* Parcelable Implementation */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(fullName);
        parcel.writeString(username);
        parcel.writeString(description);
        parcel.writeParcelable(profilePicture, i);
        parcel.writeParcelable(postPicture, i);
    }
    /* End of Parcelable Implementation */
}
