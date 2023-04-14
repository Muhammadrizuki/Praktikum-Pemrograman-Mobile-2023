package com.sisfo.tugaspraktikum6.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

<<<<<<< Updated upstream
public class ConversationList implements Parcelable {
    @SerializedName("conversations")
    private List<Conversation> conversations = new ArrayList<>();

    protected ConversationList(Parcel in) {
    }

    public static final Creator<ConversationList> CREATOR = new Creator<ConversationList>() {
        @Override
        public ConversationList createFromParcel(Parcel in) {
            return new ConversationList(in);
        }

        @Override
        public ConversationList[] newArray(int size) {
            return new ConversationList[size];
        }
    };

=======
public class ConversationList {
    @SerializedName("conversations")
    private List<Conversation> conversations = new ArrayList<>();
>>>>>>> Stashed changes
    public List<Conversation> list() {
        return conversations;
    }

<<<<<<< Updated upstream
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeList(conversations);
    }
=======
>>>>>>> Stashed changes
}
