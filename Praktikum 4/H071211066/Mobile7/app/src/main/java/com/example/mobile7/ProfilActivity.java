package com.example.mobile7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

public class ProfilActivity extends AppCompatActivity {

    private ShapeableImageView iFoto;
    private TextView tvNama, tvNomor, tvStatus, tvTanggalStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        iFoto = findViewById(R.id.foto);
        tvNama = findViewById(R.id.nama);
        tvNomor = findViewById(R.id.nomor);
        tvStatus = findViewById(R.id.status);
        tvTanggalStatus = findViewById(R.id.tanggalstatus);

        Intent terima = getIntent();
        String nama = terima.getStringExtra("varNama");
        String status = terima.getStringExtra("varStatus");
        String tanggalStatus = terima.getStringExtra("varTanggalStatus");
        String nomor = terima.getStringExtra("varNomor");
        int foto = terima.getIntExtra("1", 0);

        tvNama.setText(nama);
        tvNomor.setText(nomor);
        tvStatus.setText(status);
        tvTanggalStatus.setText(tanggalStatus);

        Glide.with(ProfilActivity.this)
                .load(foto)
                .into(iFoto);

    }
}