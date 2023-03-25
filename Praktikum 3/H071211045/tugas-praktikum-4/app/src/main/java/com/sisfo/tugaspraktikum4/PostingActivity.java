package com.sisfo.tugaspraktikum4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.sisfo.tugaspraktikum4.model.User;

public class PostingActivity extends AppCompatActivity {

    ImageView postPicture;
    EditText postDescription;
    Button postButton;
    Uri postURI;
    User user;

    private final ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), photo -> {
                if (photo.getResultCode() == RESULT_OK) {
                    Intent data = photo.getData();
                    postURI = data.getData();
                    postPicture.setImageURI(data.getData());
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);
        user = getIntent().getParcelableExtra("user");
        postPicture = findViewById(R.id.post_image);
        postDescription = findViewById(R.id.post_description);
        postButton = findViewById(R.id.submit_post);

        // Change the post picture by using photo launcher and save it for the next activity
        postPicture.setOnClickListener(v -> {
            Intent intent = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            photoLauncher.launch(Intent.createChooser(intent, "Choose a photo"));
        });

        // Extract the changed post picture's URI and pass it to the user object by using intent
        postButton.setOnClickListener(v -> {
            user.setPostPicture(postURI);
            user.setPostDescription(postDescription.getText().toString());
            Intent result = new Intent(this, ResultActivity.class).putExtra("user", user);
            startActivity(result);
        });
    }
}