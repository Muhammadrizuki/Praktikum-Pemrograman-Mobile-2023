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

public class MainActivity extends AppCompatActivity {

    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toDetail = findViewById(R.id.btnToDetail);
        EditText fullName = findViewById(R.id.etFullname);
        EditText userName = findViewById(R.id.etUsername);

        toDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fullName.getText().toString().equals("") || userName.getText().toString().equals("")){
                    if (fullName.getText().toString().equals("")) {
                        fullName.setError("Tidak boleh kosong");
                    }
                    if (userName.getText().toString().equals("")){
                        userName.setError("Tidak boleh kosong");
                    }
                } else if (uri==null) {
                        Toast.makeText(MainActivity.this, "Pilih gambar dulu bro", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentD = new Intent(MainActivity.this, DetailActivity.class);
                    intentD.putExtra("FULL_NAME", fullName.getText().toString());
                    intentD.putExtra("USER_NAME", userName.getText().toString());
                    intentD.putExtra("PROFILE_IMAGE", uri.toString());
                    startActivity(intentD);
                }
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
        } else {
            uri = data.getData();
            ImageView imageView = findViewById(R.id.ivFProfil);
            imageView.setImageURI(uri);
        }

    }

}


