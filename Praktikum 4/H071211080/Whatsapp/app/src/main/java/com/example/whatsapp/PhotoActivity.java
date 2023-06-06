package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoActivity extends AppCompatActivity {

    private ImageView im;

    private TextView tv;

    private String st1;

    private int img;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        im = findViewById(R.id.imageView);
        tv = findViewById(R.id.textview3);

        img = getIntent().getIntExtra("photo",0);
        st1 = getIntent().getStringExtra("name");

        im.setImageResource(img);
        tv.setText(st1);



    }
}