package com.example.praktikum3t1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    Uri uri;
    String fullName, userName, profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button toPost = findViewById(R.id.btnToPost);
        EditText detailCaption = findViewById(R.id.etCaption);


        fullName = getIntent().getStringExtra("FULL_NAME");
        userName = getIntent().getStringExtra("USER_NAME");
        profileImage = getIntent().getStringExtra("PROFILE_IMAGE");


        toPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intentP = new Intent(DetailActivity.this, PostActivity.class);
                    intentP.putExtra("FULL_NAME", fullName);
                    intentP.putExtra("USER_NAME", userName);
                    intentP.putExtra("PROFILE_IMAGE", profileImage);
                    intentP.putExtra("POST_IMAGE", uri.toString());
                    intentP.putExtra("POST_CAPTION", detailCaption.getText().toString());
                    startActivity(intentP);
            }
        });
    }
    public void openGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_CANCELED && data != null && data.getData() != null) {
            Toast.makeText(this, "Gambar", Toast.LENGTH_SHORT).show();
        } else {
            uri = data.getData();
            ImageView imageView = findViewById(R.id.ivPost);
            imageView.setImageURI(uri);
        }

    }

}