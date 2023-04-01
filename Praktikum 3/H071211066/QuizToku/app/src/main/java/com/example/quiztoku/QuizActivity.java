package com.example.quiztoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Collection;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_PROFIL = "extra_profil";

    public static final String EXTRA_BEST = "extra_bestskor";

    int score = 0;
    int totalSoal = SoalJawaban.soal.length;
    int indexSoal = 0;
    String pilihanJawaban = "";
    private TextView tQuiz, tSoal, tPilA, tPilB, tPilC, tPilD;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tQuiz = findViewById(R.id.quiz);
        tSoal = findViewById(R.id.soal);
        tPilA = findViewById(R.id.pilA);
        tPilB = findViewById(R.id.pilB);
        tPilC = findViewById(R.id.pilC);
        tPilD = findViewById(R.id.pilD);

        soalBaru();

    }

    void soalBaru() {
        if (indexSoal == totalSoal){
            int totalSkor = score * 20;
            String nama = getIntent().getStringExtra(EXTRA_NAMA);
            String profil = getIntent().getStringExtra(EXTRA_PROFIL);
            int bestskor = getIntent().getIntExtra(EXTRA_BEST, 0);
            Intent skor = new Intent(QuizActivity.this, SkorActivity.class);
            skor.putExtra(SkorActivity.EXTRA_SKOR, totalSkor);
            skor.putExtra(SkorActivity.EXTRA_NAMA, nama);
            skor.putExtra(SkorActivity.EXTRA_PROFIL, profil);
            skor.putExtra(SkorActivity.EXTRA_BEST, bestskor);
            startActivity(skor);
        }else {
            int soal = indexSoal+1;

            tPilA.setBackgroundResource(R.drawable.bg_soal);
            tPilB.setBackgroundResource(R.drawable.bg_soal);
            tPilC.setBackgroundResource(R.drawable.bg_soal);
            tPilD.setBackgroundResource(R.drawable.bg_soal);

            tPilA.setTextColor(Color.BLACK);
            tPilB.setTextColor(Color.BLACK);
            tPilC.setTextColor(Color.BLACK);
            tPilD.setTextColor(Color.BLACK);

            tQuiz.setText("Quiz " + soal + " of 5");

            tPilA.setEnabled(true);
            tPilB.setEnabled(true);
            tPilC.setEnabled(true);
            tPilD.setEnabled(true);

            tSoal.setText(SoalJawaban.soal[indexSoal]);
            tPilA.setText(SoalJawaban.pilihan[indexSoal][0]);
            tPilB.setText(SoalJawaban.pilihan[indexSoal][1]);
            tPilC.setText(SoalJawaban.pilihan[indexSoal][2]);
            tPilD.setText(SoalJawaban.pilihan[indexSoal][3]);
        }
    }
    public void pilA(View view) {
        pilihanJawaban = tPilA.getText().toString();
        setEnable();
        if (pilihanJawaban == SoalJawaban.jawaban[indexSoal]){
            tPilA.setTextColor(Color.WHITE);
            tPilA.setBackgroundResource(R.drawable.bg_jwb_bnr);
            score++;
            delay();
        } else {
            tPilA.setBackgroundResource(R.drawable.bg_jwb_slh);
            tPilA.setTextColor(Color.WHITE);
            delay();
        }

    }
    public void pilB(View view) {
        setEnable();
        pilihanJawaban = tPilB.getText().toString();
        if (pilihanJawaban == SoalJawaban.jawaban[indexSoal]){
            tPilB.setBackgroundResource(R.drawable.bg_jwb_bnr);
            tPilB.setTextColor(Color.WHITE);
            score++;
            delay();
        } else {
            tPilB.setBackgroundResource(R.drawable.bg_jwb_slh);
            tPilB.setTextColor(Color.WHITE);
            delay();
        }
    }
    public void pilC(View view) {
        setEnable();
        pilihanJawaban = tPilC.getText().toString();
        if (pilihanJawaban == SoalJawaban.jawaban[indexSoal]){
            tPilC.setBackgroundResource(R.drawable.bg_jwb_bnr);
            tPilC.setTextColor(Color.WHITE);
            score++;
            delay();
        } else {
            tPilC.setBackgroundResource(R.drawable.bg_jwb_slh);
            tPilC.setTextColor(Color.WHITE);
            delay();
        }
    }
    public void pilD(View view) {
        setEnable();
        pilihanJawaban = tPilD.getText().toString();
        if (pilihanJawaban == SoalJawaban.jawaban[indexSoal]){
            tPilD.setBackgroundResource(R.drawable.bg_jwb_bnr);
            tPilD.setTextColor(Color.WHITE);
            score++;
            delay();
        } else {
            tPilD.setBackgroundResource(R.drawable.bg_jwb_slh);
            tPilD.setTextColor(Color.WHITE);
            delay();
        }
    }
    private void setEnable(){
        tPilA.setEnabled(false);
        tPilB.setEnabled(false);
        tPilC.setEnabled(false);
        tPilD.setEnabled(false);
    }
    private void delay(){
        indexSoal++;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soalBaru();
            }
        }, 1000);
    }

}