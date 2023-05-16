package com.example.quiztoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SkorActivity extends AppCompatActivity {

    public static final String EXTRA_SKOR = "extra_skor";
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_PROFIL = "extra_profil";
    public static final String EXTRA_BEST = "extra_bestskor";

    private TextView tSkor, tBestSkor, tBest, tNama;
    int bestSkor = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);

        tSkor = findViewById(R.id.skor);
        tBestSkor = findViewById(R.id.bestskor);
        tBest = findViewById(R.id.tbest);
        tNama = findViewById(R.id.nama);

        int skor = getIntent().getIntExtra(EXTRA_SKOR, 0);
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        tNama.setText("GGWP " +nama+ "!");

        tSkor.setText(""+skor);

        int bestSkorn = getIntent().getIntExtra(EXTRA_BEST, 0);
        bestSkor = bestSkor + bestSkorn;

        if(skor <= bestSkor){
            tBest.setText("Best Score");
            tBestSkor.setText(String.valueOf(bestSkor));
        } else {
            bestSkor = skor;
            tBest.setText("New Best Score");
            tBestSkor.setText(String.valueOf(bestSkor));
        }
    }

    public void home(View view) {
        int best = bestSkor;
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String profil = getIntent().getStringExtra(EXTRA_PROFIL);
        Intent home = new Intent(SkorActivity.this, PlayAgainActivity.class);
        home.putExtra(PlayAgainActivity.EXTRA_BESTSKOR, best);
        home.putExtra(PlayAgainActivity.EXTRA_NAMA, nama);
        home.putExtra(PlayAgainActivity.EXTRA_PROFIL, profil);
        startActivity(home);
    }
}