package com.example.tuprak6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    String username;
    String nama;
    String caption;
    String profil;
    String postingan;

    public User() {
    }

    public User (String nama, String username, String caption, String profil, String postingan){
        this.username =username;
        this.nama = nama;
        this.caption = caption;
        this.profil = profil;
        this.postingan = postingan;
    }

    protected User(Parcel in) {
        username = in.readString();
        nama = in.readString();
        caption = in.readString();
        profil = in.readString();
        postingan = in.readString();
    }

    public User(String nama, String username, String profil) {
        this.nama = nama;
        this.username = username;
        this.profil = profil;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(nama);
        dest.writeString(caption);
        dest.writeString(profil);
        dest.writeString(postingan);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getPostingan() {
        return postingan;
    }

    public void setPostingan(String postingan) {
        this.postingan = postingan;
    }
}
