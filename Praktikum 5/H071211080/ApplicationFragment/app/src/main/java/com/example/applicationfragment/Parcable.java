package com.example.applicationfragment;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Parcable implements Parcelable {
    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    Bitmap foto;
    String text1;
    Parcable(String text1, Bitmap foto){
        this.text1 = text1;
        this.foto = foto;
    }

    protected Parcable(Parcel in) {
        foto = in.readParcelable(Bitmap.class.getClassLoader());
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
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(foto, i);
        parcel.writeString(text1);
    }
}
