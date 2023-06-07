package com.example.localdatapersistent;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class NoteModel implements Parcelable {
    private int id;
    private String judul, waktu, deskripsi;

    public NoteModel() {

    }

    public NoteModel(int id, String judul, String waktu, String deskripsi) {
        this.id = id;
        this.judul = judul;
        this.waktu = waktu;
        this.deskripsi = deskripsi;
    }

    protected NoteModel(Parcel in) {
        id = in.readInt();
        judul = in.readString();
        waktu = in.readString();
        deskripsi = in.readString();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(judul);
        parcel.writeString(waktu);
        parcel.writeString(deskripsi);
    }
}
