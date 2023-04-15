package com.example.tuprak4;

public class ModelTampilan {
    String nama;
    String isiChat;
    String time;
    int profil;
    String nohp;
    String status;
    String tanggal;

    public ModelTampilan (String nama, String isiChat, String time, int profil){
        this.nama = nama;
        this.isiChat = isiChat;
        this.profil = profil;
        this.time = time;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }

    public String getIsiChat() {
        return isiChat;
    }

    public void setIsiChat(String isiChat) {
        this.isiChat = isiChat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
