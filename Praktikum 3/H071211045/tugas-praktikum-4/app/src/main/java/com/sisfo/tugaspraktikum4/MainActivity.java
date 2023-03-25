package com.sisfo.tugaspraktikum4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sisfo.tugaspraktikum4.model.User;

public class MainActivity extends AppCompatActivity {

    ImageView profilePicture;
    EditText fullName, username;
    Button submit;
    Uri photoURI;

    User user;
    private final ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), photo -> {
                if (photo.getResultCode() == RESULT_OK) {
                    Intent data = photo.getData();
                    photoURI = data.getData();
                    profilePicture.setImageURI(data.getData());
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilePicture = findViewById(R.id.profile_input);
        fullName = findViewById(R.id.full_name_input);
        username = findViewById(R.id.username_input);
        submit = findViewById(R.id.submit_user);

        profilePicture.setOnClickListener(v -> {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            photoLauncher.launch(Intent.createChooser(intent, "Choose a photo"));
        });

        submit.setOnClickListener(v -> {
            if (user.getProfilePicture() == null) {
                Toast.makeText(this, "Please pick a profile picture first!", Toast.LENGTH_SHORT).show();

            } else if (fullName.getText().toString().isEmpty() || username.getText().toString().isEmpty()) {
                fullName.setError("Field can't be empty");
                username.setError("Field can't be empty");

            } else {
                String username = this.username.getText().toString().trim();
                String fullName = this.fullName.getText().toString().trim();

                if (username.contains(" ")) {
                    this.username.setError("Username can't contains a space");
                    return;
                }

                user = new User(fullName, username);
                user.setProfilePicture(photoURI);
                Intent next = new Intent(this, PostingActivity.class).putExtra("user", user);
                startActivity(next);
            }
        });
    }
}