package com.example.tugas3_nomor2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Player implements Parcelable {
    String user;
    int bestScore;

    Uri image;

    protected Player(Parcel in) {
        user = in.readString();
        bestScore = in.readInt();
        image = in.readParcelable(Uri.class.getClassLoader());
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

    public Player() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int i) {
        dest.writeString(user);
        dest.writeInt(bestScore);
        dest.writeParcelable(image, i);
    }

    public String getName() {
        return user;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setName(String name) {
        this.user = name;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

}

