package com.example.applicationfragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Parcable implements Parcelable {
    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    Uri imageUri; // Change the variable name from ImageUri to imageUri

    String text1;

    Parcable(String text1, Uri imageUri) { // Change the parameter name from ImageUri to imageUri
        this.text1 = text1;
        this.imageUri = imageUri;
    }

    protected Parcable(Parcel in) {
        imageUri = in.readParcelable(Uri.class.getClassLoader()); // Change from Bitmap to Uri
        text1 = in.readString();
    }

    public static final Creator<Parcable> CREATOR = new Creator<Parcable>() {
        @Override
        public Parcable createFromParcel(Parcel in) {
            return new Parcable(in);
        }

        @Override
        public Parcable[] newArray(int size) {
            return new Parcable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(imageUri, i); // Change from Bitmap to Uri
        parcel.writeString(text1);
    }
}
