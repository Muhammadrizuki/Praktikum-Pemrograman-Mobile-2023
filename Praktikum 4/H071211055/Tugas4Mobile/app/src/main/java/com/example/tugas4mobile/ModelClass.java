package com.example.tugas4mobile;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ModelClass implements Parcelable {
    private int imageView1;
    private String tv1, tv2, tv3, divider;
    private String nomor, status, tanggal;


    public ModelClass(int imageView1, String tv1, String tv2, String tv3, String divider, String nomor, String status, String tanggal) {
        this.imageView1 = imageView1;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
        this.divider = divider;
        this.nomor = nomor;
        this.status = status;
        this.tanggal = tanggal;
    }

    protected ModelClass(Parcel in) {
        imageView1 = in.readInt();
        tv1 = in.readString();
        tv2 = in.readString();
        tv3 = in.readString();
        divider = in.readString();
        nomor = in.readString();
        status = in.readString();
        tanggal = in.readString();
    }

    public static final Creator<ModelClass> CREATOR = new Creator<ModelClass>() {
        @Override
        public ModelClass createFromParcel(Parcel in) {
            return new ModelClass(in);
        }

        @Override
        public ModelClass[] newArray(int size) {
            return new ModelClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(imageView1);
        dest.writeString(tv1);
        dest.writeString(tv2);
        dest.writeString(tv3);
        dest.writeString(divider);
        dest.writeString(nomor);
        dest.writeString(status);
        dest.writeString(tanggal);
    }

    public int getImageView1() {
        return imageView1;
    }

    public String getTv1() {
        return tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public String getTv3() {
        return tv3;
    }

    public String getDivider() {
        return divider;
    }

    public String getNomor() {
        return nomor;
    }

    public String getStatus() {
        return status;
    }

    public String getTanggal() {
        return tanggal;
    }
}