package com.example.quiztoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayAgainActivity extends AppCompatActivity {

    public static final String EXTRA_BESTSKOR = "extra_bestskor";
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_PROFIL = "extra_profil";

    private TextView tScore, tNama;
    private ImageView iImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);

        tScore = findViewById(R.id.score);
        tNama = findViewById(R.id.nama);
        iImage = findViewById(R.id.image);

        int bestSkor = getIntent().getIntExtra(EXTRA_BESTSKOR, 0);
        tScore.setText("Best Score : " + bestSkor);
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        tNama.setText(nama);
        String profil = getIntent().getStringExtra(EXTRA_PROFIL);
        if (profil.equals("")){
            iImage.setImageResource(R.drawable.profile);
        } else {
            iImage.setImageURI(Uri.parse(profil));
        }
    }

    public void playagain(View view) {
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String profil = getIntent().getStringExtra(EXTRA_PROFIL);
        int bestSkor = getIntent().getIntExtra(EXTRA_BESTSKOR, 0);
        Intent quiz = new Intent(PlayAgainActivity.this, QuizActivity.class);
        quiz.putExtra(QuizActivity.EXTRA_BEST, bestSkor);
        quiz.putExtra(QuizActivity.EXTRA_NAMA, nama);
        quiz.putExtra(QuizActivity.EXTRA_PROFIL, profil);
        startActivity(quiz);
    }
}