package com.example.mobile7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FotoActivity extends AppCompatActivity {
    private TextView tvNama;
    ImageView iFoto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        iFoto = findViewById(R.id.foto);
        tvNama = findViewById(R.id.nama);

        Intent terima = getIntent();
        String nama = terima.getStringExtra("varNama");
        int foto = terima.getIntExtra("1", 0);

        tvNama.setText(nama);
        Glide.with(FotoActivity.this)
                .load(foto)
                .into(iFoto);
    }
    public void back(View view) {
        Intent back = new Intent(FotoActivity.this, MainActivity.class);
        startActivity(back);
    }
}