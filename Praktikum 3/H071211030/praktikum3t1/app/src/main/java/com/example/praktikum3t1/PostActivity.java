package com.example.praktikum3t1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class PostActivity extends AppCompatActivity {

    Uri uri;
    String postUsername, postFullname, postCaption, profilImage, postImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView profileImagePrime = findViewById(R.id.ivPostImage);
        TextView postUsernamePrime = findViewById(R.id.postUsername);
        TextView postFullnamePrime = findViewById(R.id.postFullname);
        ImageView postImagePrime = findViewById(R.id.ivPost);
        TextView postCaptionPrime = findViewById(R.id.postCaption);

        profilImage = getIntent().getStringExtra("PROFILE_IMAGE");
        postUsername = getIntent().getStringExtra("USER_NAME");
        postFullname = getIntent().getStringExtra("FULL_NAME");
        postImage = getIntent().getStringExtra("POST_IMAGE");
        postCaption = getIntent().getStringExtra("POST_CAPTION");

        profileImagePrime.setImageURI(Uri.parse(profilImage));
        postUsernamePrime.setText(postUsername);
        postFullnamePrime.setText(postFullname);
        postImagePrime.setImageURI(Uri.parse(postImage));
        postCaptionPrime.setText(postCaption);
    }


}