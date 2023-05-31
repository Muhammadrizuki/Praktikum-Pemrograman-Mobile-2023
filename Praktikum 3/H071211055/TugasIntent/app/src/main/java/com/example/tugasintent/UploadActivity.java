package com.example.tugasintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class UploadActivity extends AppCompatActivity {

    public static final String EXTRA_FULLNAME = "extra_fullname";
    public static final String EXTRA_USERNAME = "extra_username";
    public static final String EXTRA_PROFILE = "extra_profile";

    private EditText eCapt;
    ImageView image;
    private Uri uri;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        eCapt = findViewById(R.id.desc);
        image = findViewById(R.id.post);

        uri = Uri.parse("");


    }

    public void post(View view) {
        Intent image = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(image, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            uri = data.getData();
            image.setImageURI(Uri.parse(uri.toString()));
        }
    }

    public void upload(View view) {
        String post = uri.toString();
        String caption = eCapt.getText().toString();
        String fullname = getIntent().getStringExtra(EXTRA_FULLNAME);
        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        String profil = getIntent().getStringExtra(EXTRA_PROFILE);

        if (uri.toString() == null) {
            Toast.makeText(UploadActivity.this, "Please pick a picture ", Toast.LENGTH_SHORT).show();
        } else if (post.isEmpty()) {
            Toast.makeText(UploadActivity.this, "Please pick a picture ", Toast.LENGTH_SHORT).show();
        } else if (caption.isEmpty()) {
            eCapt.setError("Caption can't be Empty");
        } else {
            Intent move = new Intent(UploadActivity.this, PostActivity.class);
            move.putExtra(PostActivity.EXTRA_FULLNAME, fullname);
            move.putExtra(PostActivity.EXTRA_USERNAME, username);
            move.putExtra(PostActivity.EXTRA_PROFILE, profil);
            move.putExtra(PostActivity.EXTRA_POST, post);
            move.putExtra(PostActivity.EXTRA_CAPTION,caption);
            startActivity(move);
        }
    }
}

