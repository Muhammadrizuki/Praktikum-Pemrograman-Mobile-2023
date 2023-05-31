package com.example.tugasprak1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void move(View view) {
        Intent satu = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/_auliaaputri17?igshid=NTE5MzUyOTU="));
        startActivity(satu);
    }
}