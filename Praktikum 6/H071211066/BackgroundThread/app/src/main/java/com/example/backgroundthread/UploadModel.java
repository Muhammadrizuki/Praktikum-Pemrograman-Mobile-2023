package com.example.backgroundthread;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UploadModel implements Parcelable {
    String caption;
    String uri;
    String profile;
    String nama;
    String username;

//    public UploadModel(String caption, String uri) {
//        this.caption = caption;
//        this.uri = uri;
//    }


    public UploadModel(String caption, String uri, String profile, String nama, String username) {
        this.caption = caption;
        this.uri = uri;
        this.profile = profile;
        this.nama = nama;
        this.username = username;
    }

    protected UploadModel(Parcel in) {
        caption = in.readString();
        uri = in.readString();
//        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<UploadModel> CREATOR = new Creator<UploadModel>() {
        @Override
        public UploadModel createFromParcel(Parcel in) {
            return new UploadModel(in);
        }

        @Override
        public UploadModel[] newArray(int size) {
            return new UploadModel[size];
        }
    };

    public String getCaption() {
        return caption;
    }

    public String getUri() {
        return uri;
    }

    public String getProfile() {
        return profile;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(caption);
        parcel.writeString(uri);
    }
}
