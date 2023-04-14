package com.sisfo.tugaspraktikum6.model;

<<<<<<< Updated upstream
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Conversation {
=======
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Conversation implements Parcelable {
>>>>>>> Stashed changes
    @SerializedName("number")
    private String number;

    @SerializedName("bubble")
<<<<<<< Updated upstream
    private List<Bubble> bubbles;

    public Conversation(String number, List<Bubble> bubbles) {
        this.number = number;
        this.bubbles = bubbles;
    }

=======
    private List<Bubble> bubbles = new ArrayList<>();

    protected Conversation(Parcel in) {
        number = in.readString();
        in.readList(bubbles, Bubble.class.getClassLoader());
    }

    public static final Creator<Conversation> CREATOR = new Creator<Conversation>() {
        @Override
        public Conversation createFromParcel(Parcel in) {
            return new Conversation(in);
        }

        @Override
        public Conversation[] newArray(int size) {
            return new Conversation[size];
        }
    };

>>>>>>> Stashed changes
    public String getNumber() {
        return number;
    }

    public List<Bubble> getBubbles() {
        return bubbles;
    }
<<<<<<< Updated upstream
=======

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(number);
        parcel.writeList(bubbles);
    }
>>>>>>> Stashed changes
}

