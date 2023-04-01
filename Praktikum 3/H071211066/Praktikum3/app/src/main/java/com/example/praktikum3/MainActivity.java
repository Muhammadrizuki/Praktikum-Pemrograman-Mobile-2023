package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_NIM = "extra_nim";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_PASSWORD = "extra_password";

    private TextView tNama, tNim, tEmail, tPass;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tNama = findViewById(R.id.nama);
        tNim = findViewById(R.id.nim);
        tEmail = findViewById(R.id.email);
        tPass = findViewById(R.id.tes);

        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        String nim = getIntent().getStringExtra(EXTRA_NIM);
        String password = getIntent().getStringExtra(EXTRA_PASSWORD);

        tNama.setText("Nama : " + nama);
        tNim.setText("NIM : " + nim);
        tEmail.setText("Email : " + email);
        tPass.setText("Password : " + password);
    }

}