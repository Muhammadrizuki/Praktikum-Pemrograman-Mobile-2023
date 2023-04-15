package com.example.tuprak4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity3 extends AppCompatActivity {
    TextView tv_back, tv_nama, tv_nomor, tv_status, tv_tanggal;
    ShapeableImageView iv_profil;
    TampilanChat tampilanChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_back = findViewById(R.id.tv_back);
        tv_nama = findViewById(R.id.tv_nama);
        tv_nomor = findViewById(R.id.tv_nomor);
        tv_status = findViewById(R.id.tv_status);
        tv_tanggal = findViewById(R.id.tv_tanggal);
        iv_profil = findViewById(R.id.iv_profil);

        Intent intent = getIntent();
        String profil = intent.getStringExtra("profil");
        String nama = intent.getStringExtra("nama");
        String nohp = intent.getStringExtra("nohp");
        String status = intent.getStringExtra("status");
        String tanggal = intent.getStringExtra("tanggal");

        tv_nama.setText(nama);
        tv_nomor.setText(nohp);
        tv_status.setText(status);
        tv_tanggal.setText(tanggal);
        iv_profil.setImageResource(Integer.parseInt(profil));

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, new Intent().putExtra("back", (CharSequence) tampilanChat));
                finish();
            }
        });

        iv_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("profil", profil);
                intent.putExtra("nama", nama);
                startActivity(intent);
            }
        });
    }
}