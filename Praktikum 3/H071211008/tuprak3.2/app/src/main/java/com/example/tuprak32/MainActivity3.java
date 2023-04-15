package com.example.tuprak32;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private ImageView iv_profil, iv_foto;
    private TextView tv_user, tv_nama, tv_caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        iv_profil = findViewById(R.id.iv_profil);
        iv_foto = findViewById(R.id.iv_foto);
        tv_nama = findViewById(R.id.tv_nama);
        tv_user = findViewById(R.id.tv_user);
        tv_caption =  findViewById(R.id.tv_caption);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String user = intent.getStringExtra("user");
        String caps = intent.getStringExtra("caps");

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            Bitmap bitmap = bundle.getParcelable("foto");
            iv_foto.setImageBitmap(bitmap);
        }

        Bitmap bitmap = intent.getParcelableExtra("profil");
        tv_nama.setText(nama);
        tv_user.setText(user);
        tv_caption.setText(caps);
        iv_profil.setImageBitmap(bitmap);
    }
}