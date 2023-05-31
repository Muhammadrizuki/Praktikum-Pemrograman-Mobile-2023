package com.example.tugas4mobile;

import static com.example.tugas4mobile.R.id.arrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private  TextView nama, nomor, status, tanggal;
    private  ImageView imageView;

    ModelClass modelClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       nama = findViewById(R.id.namauser);
       nomor = findViewById(R.id.nomor);
       status = findViewById(R.id.status);
       tanggal = findViewById(R.id.tanggal);
       imageView = findViewById(R.id.foto2);


        modelClass = getIntent().getParcelableExtra("semua data");
        imageView.setImageResource(modelClass.getImageView1());
        nama.setText(modelClass.getTv1());
        nomor.setText(modelClass.getNomor());
        status.setText(modelClass.getStatus());
        tanggal.setText(modelClass.getTanggal());




    }





    public void back(View view) {
        finish();
    }

    public void seefoto(View view) {
        Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
        intent.putExtra("foto",modelClass);
        startActivity(intent);
    }


}