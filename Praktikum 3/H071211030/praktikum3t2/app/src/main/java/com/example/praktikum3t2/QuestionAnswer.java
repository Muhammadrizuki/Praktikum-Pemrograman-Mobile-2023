package com.example.praktikum3t2;

public class QuestionAnswer {

    public static String question[] ={
            "Berapa banyak kartu dalam satu set kartu remi?",
            "Apa perbedaan antara kartu remi biasa dan kartu remi bridge?",
            "Apa saja jenis simbol pada kartu remi?",
            "Permainan kartu apa yang menggunakan kartu remi?",
            "Bagaimana cara merawat kartu remi agar tetap awet?",
            "Berapa banyak jenis kartu remi yang ada dalam satu suit?",
            "Apa nama susunan kartu terkuat dalam permainan poker?",
            "Permainan kartu apa yang mengharuskan pemain untuk mengumpulkan kartu sejenis dengan nilai yang sama?",
            "Apa istilah yang digunakan untuk menggambarkan ketika kedua pemain memiliki kartu dengan nilai yang sama dalam permainan kartu?"
    };

    public static String choices[][] = {
            {"48 kartu",
            "52 kartu",
            "56 kartu",
            "60 kartu"}, //B

            {"Kartu remi bridge lebih kecil dan lebih pendek",
            "Kartu remi biasa lebih kecil dan lebih pendek",
            "Kartu remi bridge lebih besar dan lebih panjang",
            "Kartu remi biasa lebih besar dan lebih panjang"}, //C

            {"Sekop, hati, keriting, wajik",
            "Lingkaran, segitiga, persegi, bulat",
            "Berlian, bintang, bulan, matahari",
            "Hati, tangan, kaki, kepala"}, //A

            {"Chess",
            "Monopoly",
            "Poker",
            "Scrabble"}, //C

            {"Jangan melipat atau menekuk kartu, simpan di tempat yang kering dan terlindungi dari sinar matahari langsung",
            "Lipat atau tekan-tekan kartu agar lebih lentur, simpan di tempat yang lembab agar tidak kering",
            "Cuci kartu dengan air sabun dan gosok-gosok, keringkan di bawah sinar matahari langsung",
            "Gunakan tangan yang basah saat memainkan kartu"}, //A

            {"9",
            "10",
            "11",
            "13"}, //D

            {"Three of a Kind",
            "Straight",
            "Flush",
            "Royal Flush"}, //D

            {"Bridge",
            "Poker",
            "Rummy",
            "Solitaire"}, //C

            {"Draw",
            "Split pot",
            "Flush",
            "Full house"}, //B
    };

    public static String correctAnswers[] = {
        "52 Kartu",
        "Kartu remi bridge lebih besar dan lebih panjang",
        "Sekop, hati, keriting, wajik",
        "Poker",
        "Jangan melipat atau menekuk kartu, simpan di tempat yang kering dan terlindungi dari sinar matahari langsung",
        "13",
        "Royal Flush",
        "Rummy",
        "Split pot"
    };
}
