package com.example.tugas4mobile;

import android.widget.TextView;

public class ModelClass2 {

    private String pesan,waktu, nama;


    ModelClass2(String pesan, String waktu, String nama){
        this.pesan = pesan;
        this.waktu = waktu;
        this.nama = nama;
    }

    public String getPesan() {
        return pesan;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getNama() {
        return nama;
    }
}
