package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_NIM = "extra_nim";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_PASSWORD = "extra_password";

    private  String nama, nim, email, password;
    private EditText editNama, editNim, editEmail, editPassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editNama = findViewById(R.id.nama);
        editNim = findViewById(R.id.nim);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
    }

    public void regis(View view) {
        nama = editNama.getText().toString();
        email = editEmail.getText().toString();
        nim = editNim.getText().toString();
        password = editPassword.getText().toString();

        Intent regis = new Intent(RegisterActivity.this, LoginActivity.class);
        regis.putExtra(LoginActivity.EXTRA_NAMA, nama);
        regis.putExtra(LoginActivity.EXTRA_NIM, nim);
        regis.putExtra(LoginActivity.EXTRA_EMAIL, email);
        regis.putExtra(LoginActivity.EXTRA_PASSWORD, password);

        startActivity(regis);
    }
}