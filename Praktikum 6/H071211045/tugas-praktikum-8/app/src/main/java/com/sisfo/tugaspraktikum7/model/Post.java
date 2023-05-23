package com.sisfo.tugaspraktikum7.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable {
    private String username;
    private String image;
    private String caption;

    public Post(String username, String image, String caption) {
        this.username = username;
        this.image = image;
        this.caption = caption;
    }

    protected Post(Parcel in) {
        username = in.readString();
        image = in.readString();
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

    public String getUsername() {
        return username;
    }

    public String getImage() {
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
        parcel.writeString(username);
        parcel.writeString(image);
        parcel.writeString(caption);
    }

}
