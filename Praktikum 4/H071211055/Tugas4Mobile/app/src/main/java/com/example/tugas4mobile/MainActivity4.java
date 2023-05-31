package com.example.tugas4mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    ImageView imageView;
    TextView nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView = findViewById(R.id.profile);
        nama = findViewById(R.id.nama);

        ModelClass modelClass = getIntent().getParcelableExtra("foto");
        imageView.setImageResource(modelClass.getImageView1());
        nama.setText(modelClass.getTv1());


    }

    public void backToChat(View view) {
        finish(); //ini supaya kembali ke activity sebelumnya
    }
}