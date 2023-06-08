package com.sisfo.tugaspraktikum6.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sisfo.tugaspraktikum6.R;
import com.sisfo.tugaspraktikum6.model.Contact;

public class ProfileActivity extends AppCompatActivity {

    Contact profile;
    TextView name, number, status, statusDate;
    ImageView profilePicture, backButton;
    CardView profilePictureCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = getIntent().getParcelableExtra("contact");

        name = findViewById(R.id.profile_contact_name);
        number = findViewById(R.id.profile_contact_number);
        status = findViewById(R.id.profile_contact_status);
        statusDate = findViewById(R.id.profile_contact_status_date);
        profilePicture = findViewById(R.id.profile_contact_image);
        profilePictureCard = findViewById(R.id.profile_contact_image_container);
        backButton = findViewById(R.id.profile_back_button);

        backButton.setOnClickListener(v -> finish());

        profilePictureCard.setOnClickListener(v -> {
            Intent toImage = new Intent(this, ImageActivity.class)
                    .putExtra("imageContent", profile.getProfilePicture());
            startActivity(toImage);
        });

        if (!profile.getName().isEmpty()) {
            name.setText(profile.getName());
            number.setText(profile.getNumber());
        } else {
            name.setText(profile.getNumber());
            number.setText("");
        }

        status.setText(profile.getStatus());
        statusDate.setText(profile.getStatusDate());

        if (!profile.getProfilePicture().isEmpty())
            Glide.with(this).load(profile.getProfilePicture()).into(profilePicture);
    }
}