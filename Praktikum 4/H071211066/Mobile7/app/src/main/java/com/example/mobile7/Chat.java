package com.example.mobile7;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Chat implements Parcelable {

    private String nama;
    private String chat;
    private String foto;
    protected Chat(Parcel in) {
    }

    public static final Creator<Chat> CREATOR = new Creator<Chat>() {
        @Override
        public Chat createFromParcel(Parcel in) {
            return new Chat(in);
        }

        @Override
        public Chat[] newArray(int size) {
            return new Chat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
    }
}
