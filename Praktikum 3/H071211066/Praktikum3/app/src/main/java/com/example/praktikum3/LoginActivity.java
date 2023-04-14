package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_NIM = "extra_nim";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_PASSWORD = "extra_password";

    private EditText editNim, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editNim = findViewById(R.id.nim);
        editPassword = findViewById(R.id.password);

        String nim = getIntent().getStringExtra(EXTRA_NIM);
        String password = getIntent().getStringExtra(EXTRA_PASSWORD);

        editNim.setText(nim);
        editPassword.setText(password);
    }

    public void login(View view) {
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        String nim = getIntent().getStringExtra(EXTRA_NIM);
        String password = getIntent().getStringExtra(EXTRA_PASSWORD);

        Intent login = new Intent(LoginActivity.this, MainActivity.class);
        login.putExtra(LoginActivity.EXTRA_NAMA, nama);
        login.putExtra(LoginActivity.EXTRA_NIM, nim);
        login.putExtra(LoginActivity.EXTRA_EMAIL, email);
        login.putExtra(LoginActivity.EXTRA_PASSWORD, password);
        startActivity(login);
    }
}