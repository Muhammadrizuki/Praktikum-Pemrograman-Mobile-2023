package com.sisfo.tugaspraktikum5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    EditText nameInput;
    ImageView profilePictureInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilePictureInput = findViewById(R.id.profile_picture_input);
        nameInput = findViewById(R.id.name_input);
        startButton = findViewById(R.id.start_button);

        startButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String profilePicture = profilePictureInput.toString();
            Intent intent = new Intent(this, ScoreActivity.class);
//            intent.putExtra("name", name);
//            intent.putExtra("profilePicture", profilePicture);
            startActivity(intent);
        });
    }
}