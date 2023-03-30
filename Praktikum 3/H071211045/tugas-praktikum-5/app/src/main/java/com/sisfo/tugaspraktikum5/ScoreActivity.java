package com.sisfo.tugaspraktikum5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sisfo.tugaspraktikum5.model.Player;

public class ScoreActivity extends AppCompatActivity {

    private Button playAgain;
    private TextView scoreTv, highScoreTv, usernameTv;
    private ImageView profilePicture;
    private ImageButton back;
    private Player player;

    private int score, highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        player = getIntent().getParcelableExtra("player");
        score = player.getScore();

        playAgain = findViewById(R.id.play_again);
        back = findViewById(R.id.back);
        scoreTv = findViewById(R.id.score);
        highScoreTv = findViewById(R.id.high_score);
        usernameTv = findViewById(R.id.username);
        profilePicture = findViewById(R.id.profile_picture);

        System.out.println("Score: " + score);

        if (score >= highScore) {
            highScore = score;
        }

        scoreTv.setText(String.valueOf(score));
        highScoreTv.setText(String.valueOf(highScore));
        usernameTv.setText(player.getName());
        profilePicture.setImageURI(player.getProfilePicture());

        playAgain.setOnClickListener(v -> {
            startActivity(new Intent(this, QuizActivity.class).putExtra("player", player));
            finish();
        });

        back.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}