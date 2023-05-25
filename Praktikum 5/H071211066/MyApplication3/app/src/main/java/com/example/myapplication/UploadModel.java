package com.example.myapplication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UploadModel implements Parcelable {
    String caption;
    Uri uri;

    public UploadModel(String caption, Uri uri) {
        this.caption = caption;
        this.uri = uri;
    }

    protected UploadModel(Parcel in) {
        caption = in.readString();
        uri = in.readParcelable(Uri.class.getClassLoader());
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

    public Uri getUri() {
        return uri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(caption);
        parcel.writeParcelable(uri, i);
    }
}
