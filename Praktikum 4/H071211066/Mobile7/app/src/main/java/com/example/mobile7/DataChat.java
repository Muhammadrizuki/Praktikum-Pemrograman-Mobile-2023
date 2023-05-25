package com.example.mobile7;

import android.graphics.ColorSpace;

import java.util.ArrayList;
import java.util.Collections;

public class DataChat {
    private static String nama [] = {
          "Catatan",
          "Bro",
          "Djul",
          "Kak Kia",
          "Kk Mel",
          "Aisyah",
          "Febi",
          "Kak neni",
          "Listrik Unhas",
          "T Nasiah",
          "Dhiya",
          "Abang",
          ":)"
    };
    private static String chatterakhir [] = {
            "Nabila 82, ilham 80, adnan 85",
            "Lg Apa?",
            "Blng klw sdh ad bapak",
            "Tapi klw sdh jln plng jgn mi",
            "Assalamu'alaikum kak mel",
            "Sama-sama ke kampus nah",
            "Sdh bangun?",
            "Klw ad mau di sambungkan sama mama",
            "Assalamu'alaikum kak, saya mau bayar listrik untuk bulan ini",
            "Assalamu'alakum Tante, maaf tdi tdk angkat telpon lagi kuliah.",
            "Dhiyaaa",
            "Abang",
            "p"
    };
    private static String jamt [] = {
            "23.24",
            "22.35",
            "20.28",
            "19.06",
            "15.03",
            "12.20",
            "10.45",
            "10.24",
            "10.16",
            "09.36",
            "09.00",
            "07.08",
            "07.03"

    };

    private static int foto[] = {
            R.drawable.catatan,
            R.drawable.bro,
            R.drawable.djul,
            R.drawable.kakkia,
            R.drawable.kkmel,
            R.drawable.aisyah,
            R.drawable.febi,
            R.drawable.kakneni,
            R.drawable.listrik,
            R.drawable.tnasiah,
            R.drawable.febi,
            R.drawable.kakkia,
            R.drawable.catatan
    };

    public static String nomor [] = {
            "082350787677",
            "082350787679",
            "082350787577",
            "082350723677",
            "082309787677",
            "082350787677",
            "082150787677",
            "082350787677",
            "082376787677",
            "082359087677",
            "082350347677",
            "082350287677",
            "082370787677",
    };
    public static String status [] = {
            "Sibuk",
            "Ada",
            "Panggilan mendesak saja",
            "Sibuk",
            "Sibuk",
            "Bismillah",
            "Lagi ujian",
            "Sibuk",
            "Ada",
            "Panggilan mendesak saja",
            "Ntahlah",
            "Panggilan mendesak saja",
            "Panggilan mendesak saja",
    };
    public static String tanggalStatus [] = {
            "03 April 2023",
            "12 Februari 2022",
            "07 Maret 2021",
            "16 Juni 2022",
            "25 Juli 2021",
            "02 Agustus 2021",
            "03 April 2023",
            "12 Februari 2022",
            "07 Maret 2021",
            "16 Juni 2022",
            "25 Juli 2021",
            "02 Agustus 2021",
            "09 Mei 2020"
    };
    public static ArrayList<ModelChat> ambilDataChat() {
        ArrayList<ModelChat> dataChat = new ArrayList<>();
        for (int i = 0; i < nama.length; i++) {
            ModelChat model = new ModelChat();
            model.setNama(nama[i]);
            model.setChat(chatterakhir[i]);
            model.setJam(jamt[i]);
            model.setFoto(foto[i]);
            model.setNomor(nomor[i]);
            model.setStatus(status[i]);
            model.setTanggalStatus(tanggalStatus[i]);

            dataChat.add(model);
        }
        return dataChat;
    }

    public static ArrayList<ModelChat> dataDetailChat() {
        ArrayList<ModelChat> dataDetail = new ArrayList<>();
        for (int i = 0; i < nama.length; i++) {
            ModelChat model = new ModelChat();
            model.setChat(chatterakhir[i]);
            model.setJam(jamt[i]);

            dataDetail.add(model);
        }
        return dataDetail;
    }

}
