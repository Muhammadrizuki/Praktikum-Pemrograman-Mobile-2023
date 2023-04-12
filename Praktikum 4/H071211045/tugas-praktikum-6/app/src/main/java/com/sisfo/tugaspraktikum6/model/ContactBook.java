package com.sisfo.tugaspraktikum6.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ContactBook implements Parcelable {
    @SerializedName("contacts")
    private List<Contact> contacts = new ArrayList<>();

    protected ContactBook() {}

    public static final Creator<ContactBook> CREATOR = new Creator<ContactBook>() {
        @Override
        public ContactBook createFromParcel(Parcel in) {
            return new ContactBook();
        }

        @Override
        public ContactBook[] newArray(int size) {
            return new ContactBook[size];
        }
    };

    public List<Contact> list() {
        return contacts;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeList(contacts);
    }
}
