package com.sisfo.tugaspraktikum5.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class Player implements Parcelable {
    public String playerName;
    public Uri profilePicture;
    public int score, highScore;

    public Player(String name, Uri profilePicture) {
        this.playerName = name;
        this.profilePicture = profilePicture;
    }

    protected Player(Parcel in) {
        playerName = in.readString();
        profilePicture = in.readParcelable(Uri.class.getClassLoader());
        score = in.readInt();
        highScore = in.readInt();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.playerName;
    }

    public Uri getProfilePicture() {
        return this.profilePicture;
    }

    public int getHighScore() {
        return this.highScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(playerName);
        parcel.writeParcelable(profilePicture, i);
        parcel.writeInt(score);
        parcel.writeInt(highScore);
    }
}
