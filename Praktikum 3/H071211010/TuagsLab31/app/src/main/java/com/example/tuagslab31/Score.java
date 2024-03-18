package com.example.tuagslab31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    ImageView Profil;
    TextView tvname, tvbestscore;
    Button btnplay;
    String Name;
    int bsscore = 0;
    Photo photo;
    Intent Bonteng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Profil = findViewById(R.id.foto);
        tvname = findViewById(R.id.name);
        tvbestscore = findViewById(R.id.score);
        btnplay = findViewById(R.id.btnplay);

        Bonteng = getIntent();
        Name = Bonteng.getStringExtra("FULL NAME");
        bsscore = Bonteng.getIntExtra("BEST SCORE",0);
        photo = Bonteng.getParcelableExtra("PROFIL");

        tvname.setText(Name);
        Profil.setImageURI(photo.getFotoUri());
        tvbestscore.setText(String.valueOf(bsscore));

        if (bsscore != 0) {
            btnplay.setText("PLAY AGAIN");
        }
        // untuk mengirim data ke intent
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Score.this, Quiz.class);
                intent.putExtra("FULL NAME", Name);
                intent.putExtra("BEST SCORE", bsscore);
                intent.putExtra("PROFIL", photo);
                startActivity(intent);
            }
        });
    }
}