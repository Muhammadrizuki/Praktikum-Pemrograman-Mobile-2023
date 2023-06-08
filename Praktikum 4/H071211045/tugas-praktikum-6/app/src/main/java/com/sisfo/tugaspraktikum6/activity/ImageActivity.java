package com.sisfo.tugaspraktikum6.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sisfo.tugaspraktikum6.R;

public class ImageActivity extends AppCompatActivity {

    ImageButton backButton;
    ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        String image = getIntent().getStringExtra("imageContent");
        int height = getResources().getDisplayMetrics().widthPixels;

        backButton = findViewById(R.id.image_back_button);
        profileImage = findViewById(R.id.content);

        backButton.setOnClickListener(v -> finish());
        Glide.with(this).load(image).into(profileImage);
        profileImage.getLayoutParams().height = height;
    }
}