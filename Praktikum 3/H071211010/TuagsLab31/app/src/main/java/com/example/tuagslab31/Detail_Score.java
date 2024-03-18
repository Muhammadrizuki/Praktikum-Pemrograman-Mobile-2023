package com.example.tuagslab31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail_Score extends AppCompatActivity {
TextView tvname, tvscore, tvbestscore;
Photo photo;
Button btnback;
//untuk menampilkan data dari score ke detail score
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_score);

        tvname = findViewById(R.id.name);
        tvscore = findViewById(R.id.score);
        tvbestscore = findViewById(R.id.bscore);
        btnback = findViewById(R.id.btn_back);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("FULL NAME");
        photo = intent.getParcelableExtra("PROFIL");
        int score = intent.getIntExtra("SCORE", 0);
        int bScore = intent.getIntExtra("BEST SCORE", 0) ;

        tvname.setText(Name);
        tvscore.setText(String.valueOf(score));
        tvbestscore.setText(String.valueOf(bScore));
 // membuat tombol back untuk kembali ke score
        btnback.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Detail_Score.this, Score.class);
                intent.putExtra("SCORE", score);
                intent.putExtra("BEST SCORE", bScore);
                intent.putExtra("FULL NAME", Name);
                intent.putExtra("PROFIL", photo);
                startActivity(intent);
                finish();
            }
        }));

    }
}