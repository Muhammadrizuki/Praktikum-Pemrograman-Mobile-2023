package com.example.tugas3_nomor2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    ShapeableImageView image;
    private EditText user;
    private TextView name, score;
    Button apply, play;
    private CardView card;
    private Uri uri;
    private Player player;

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            Intent resultIntent = result.getData();
            if (resultIntent != null) {
                uri = resultIntent.getData();
                image.setImageURI(uri);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        name = findViewById(R.id.user_name);
        image = findViewById(R.id.profil);
        apply = findViewById(R.id.btnApply);
        play = findViewById(R.id.btnPlay);
        card = findViewById(R.id.cardView1);
        score = findViewById(R.id.user_score);

        user.setVisibility(View.VISIBLE);
        image.setVisibility(View.VISIBLE);
        name.setVisibility(View.GONE);
        apply.setVisibility(View.VISIBLE);
        play.setVisibility(View.GONE);
        score.setVisibility(View.GONE);

        if (getIntent().getParcelableExtra(MainActivity2.EXTRA_PLAYER) != null) {
            player = getIntent().getParcelableExtra(MainActivity2.EXTRA_PLAYER);
            name.setVisibility(View.VISIBLE);
            user.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            apply.setVisibility(View.GONE);
            play.setVisibility(View.VISIBLE);
            score.setVisibility(View.VISIBLE);

            String Names = player.getName();
            name.setText(Names);
            int Score = player.getBestScore();
            score.setText("Best Score :" + Score);
        } else {
            player = new Player();
        }

        apply.setOnClickListener(view -> {
            if (user.getText().toString().isEmpty()) {
                user.setError("Please input your name");
            } else {
                user.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
                name.setVisibility(View.VISIBLE);
                apply.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
                score.setVisibility(View.VISIBLE);
                card.setVisibility(View.VISIBLE);

                player.setName(user.getText().toString());
                String Names = player.getName();
                name.setText(Names);
                int Score = player.getBestScore();
                score.setText("Best Score : " + Score);
            }
        });

        play.setOnClickListener(view ->{
            Intent play = new Intent(MainActivity.this,MainActivity2.class);
            play.putExtra(MainActivity2.EXTRA_PLAYER,player);

            startActivity(play);
        });
        image.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            launcher.launch(Intent.createChooser(intent, "Select a Picture"));
            startActivity(intent);
        });

    }
}