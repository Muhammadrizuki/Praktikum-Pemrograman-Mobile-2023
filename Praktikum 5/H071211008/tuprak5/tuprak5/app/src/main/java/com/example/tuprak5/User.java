package com.example.tuprak5;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Parcelable {

    private Bitmap Foto;
    private  String caption;
    public User() {
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

    public Bitmap getFoto() {
        return Foto;
    }

    public void setFoto(Bitmap Foto) {
        this.Foto = Foto;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    User(Bitmap foto, String caption){
        this.Foto = foto;
        this.caption = caption;
    }

    protected User(Parcel in) {
        Foto = in.readParcelable(Bitmap.class.getClassLoader());
        caption = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(Foto,i);
        parcel.writeString(caption);
    }
}
