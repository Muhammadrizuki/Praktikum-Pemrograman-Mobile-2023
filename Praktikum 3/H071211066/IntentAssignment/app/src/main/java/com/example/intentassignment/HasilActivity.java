package com.example.intentassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_USER = "extra_user";
    public static final String EXTRA_CAPTION = "extra_capt";
    public static final String EXTRA_PROFILE = "extra_profile";
    public static final String EXTRA_POST = "extra_post";

    private TextView tUNama, tNama, tCapt;

    private ImageView iProfile, iPost;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tUNama = findViewById(R.id.tUNama);
        tNama = findViewById(R.id.tnama);
        tCapt = findViewById(R.id.tCapt);
        iProfile = findViewById(R.id.profile);
        iPost = findViewById(R.id.post);

        String nama = getIntent().getStringExtra(EXTRA_NAME);
        String username = getIntent().getStringExtra(EXTRA_USER);
        String caption = getIntent().getStringExtra(EXTRA_CAPTION);
        String profile = getIntent().getStringExtra(EXTRA_PROFILE);
        String post = getIntent().getStringExtra(EXTRA_POST);

        tUNama.setText(username);
        tNama.setText(nama);
        tCapt.setText(caption);
        iPost.setImageURI(Uri.parse(post));
        iProfile.setImageURI(Uri.parse(profile));
    }
}