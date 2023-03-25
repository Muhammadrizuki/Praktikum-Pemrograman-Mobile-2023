package com.sisfo.tugaspraktikum4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sisfo.tugaspraktikum4.model.User;

public class ResultActivity extends AppCompatActivity {

    TextView fullName, username, description;
    ImageView profilePicture, postPicture;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        fullName = findViewById(R.id.post_full_name);
        username = findViewById(R.id.post_username);
        description = findViewById(R.id.post_description);

        profilePicture = findViewById(R.id.post_profile_image);
        postPicture = findViewById(R.id.post_image);

        user = getIntent().getParcelableExtra("user");

        /* User data */
        postPicture.setImageURI(user.getPostPicture());
        fullName.setText(user.getFullName());
        username.setText(user.getUsername());

        /* Post data */
        profilePicture.setImageURI(user.getProfilePicture());
        description.setText(user.getPostDescription());
    }
}