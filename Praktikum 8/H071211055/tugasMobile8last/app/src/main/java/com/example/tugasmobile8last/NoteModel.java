package com.example.tugasmobile8last;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class NoteModel implements Parcelable {
    private int id;
    private String Title;
    private String Desc;

    protected NoteModel(Parcel in) {
        id = in.readInt();
        Title = in.readString();
        Desc = in.readString();
    }

    public static final Creator<NoteModel> CREATOR = new Creator<NoteModel>() {
        @Override
        public NoteModel createFromParcel(Parcel in) {
            return new NoteModel(in);
        }

        @Override
        public NoteModel[] newArray(int size) {
            return new NoteModel[size];
        }
    };

    public NoteModel(int id, String title, String description) {
    }

    public NoteModel() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(Title);
        dest.writeString(Desc);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
