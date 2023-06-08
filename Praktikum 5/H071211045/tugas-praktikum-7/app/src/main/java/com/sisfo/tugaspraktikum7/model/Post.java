package com.sisfo.tugaspraktikum7.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable {
    private String fullName, username;
    private Uri image;
    private String caption;

    public Post(String fullName, String username, Uri image, String caption) {
        this.fullName = fullName;
        this.username = username;
        this.image = image;
        this.caption = caption;
    }

    protected Post(Parcel in) {
        fullName = in.readString();
        username = in.readString();
        image = in.readParcelable(Uri.class.getClassLoader());
        caption = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public Uri getImage() {
        return image;
    }

    public String getCaption() {
        return caption;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(fullName);
        parcel.writeString(username);
        parcel.writeParcelable(image, i);
        parcel.writeString(caption);
    }
}
