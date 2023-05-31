package com.example.tugas3_nomor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public static String EXTRA_SCORE;
    private TextView Score, newScore, ggwp;
    private Button backToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Score = findViewById(R.id.score);
        newScore = findViewById(R.id.new_score);
        backToHome = findViewById(R.id.back);
        ggwp = findViewById(R.id.ggwp);

        int YouScore = getIntent().getIntExtra(EXTRA_SCORE, 0);
        Player player = getIntent().getParcelableExtra(MainActivity2.EXTRA_PLAYER);
        ggwp.setText("ggwp "+player.getName());

        Score.setText(String.valueOf(YouScore));

        if (YouScore > player.getBestScore()) {
            player.setBestScore(YouScore);
            newScore.setText(String.valueOf(player.getBestScore()));
        }else {
            newScore.setText(String.valueOf(player.getBestScore()));
        }

        backToHome.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra(MainActivity2.EXTRA_PLAYER,player);
            startActivity(intent);
        });
    }

}