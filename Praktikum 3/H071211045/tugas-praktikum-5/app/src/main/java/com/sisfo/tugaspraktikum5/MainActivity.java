package com.sisfo.tugaspraktikum5;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.sisfo.tugaspraktikum5.model.Player;

public class MainActivity extends AppCompatActivity {
    private Button startButton;
    private EditText nameInput;
    public Player player;
    public Uri profilePicture;
    private ImageView profilePictureInput;

    private final ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), photo -> {
                if (photo.getResultCode() == RESULT_OK) {
                    Intent data = photo.getData();
                    profilePicture = data.getData();
                    profilePictureInput.setImageURI(profilePicture);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilePictureInput = findViewById(R.id.profile_picture_input);
        nameInput = findViewById(R.id.name_input);
        startButton = findViewById(R.id.start_button);

        if (getIntent().getParcelableExtra("player") != null) {
            player = getIntent().getParcelableExtra("player");
            nameInput.setText(player.getName());
            profilePictureInput.setImageURI(player.getProfilePicture());
        }

        profilePictureInput.setOnClickListener(v -> {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            photoLauncher.launch(Intent.createChooser(intent, "Choose a photo"));
        });

        startButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();

            if (name.isEmpty()) {
                nameInput.setError("Name cannot be empty!");
                return;
            }

            player = new Player(name, profilePicture);
            startActivity(new Intent(this, QuizActivity.class).putExtra("player", player));
            finish();
        });
    }
}