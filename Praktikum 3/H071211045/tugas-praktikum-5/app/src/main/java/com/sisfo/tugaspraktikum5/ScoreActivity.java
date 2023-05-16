package com.sisfo.tugaspraktikum5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
    private Uri playerImage;
    private int score, highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        player = getIntent().getParcelableExtra("player");
        score = player.getScore();

        playerImage = player.getProfilePicture();

        playAgain = findViewById(R.id.play_again);
        back = findViewById(R.id.back);
        scoreTv = findViewById(R.id.score);
        highScoreTv = findViewById(R.id.high_score);
        usernameTv = findViewById(R.id.username);

        profilePicture = findViewById(R.id.profile_picture);
        profilePicture.setImageURI(playerImage);


        if (score >= highScore) {
            highScore = score;
            player.setHighScore(highScore);
            highScoreTv.setText(String.valueOf(highScore));

        } else highScoreTv.setText(player.getHighScore());

        scoreTv.setText(String.valueOf(score));
        usernameTv.setText(player.getName());

        playAgain.setOnClickListener(v -> {
            startActivity(new Intent(this, QuizActivity.class).putExtra("player", player));
            finish();
        });

        back.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class).putExtra("player", player));
            finish();
        });
    }
}