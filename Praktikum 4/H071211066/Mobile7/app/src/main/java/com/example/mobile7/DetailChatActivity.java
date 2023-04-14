package com.example.mobile7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class DetailChatActivity extends AppCompatActivity {
    private ShapeableImageView iFoto;
    private TextView tvNama, tvChat, tvJam, tvStatus, tvTanggalStatus, tvNomor;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_chat);

        iFoto = findViewById(R.id.foto);
        tvNama = findViewById(R.id.nama);
        tvChat = findViewById(R.id.chat);
        tvJam = findViewById(R.id.jam);
        tvNomor = findViewById(R.id.nomor);
        tvStatus = findViewById(R.id.status);
        tvTanggalStatus = findViewById(R.id.tanggalstatus);

        Intent terima = getIntent();
        String nama = terima.getStringExtra("varNama");
        String chat = terima.getStringExtra("varChat");
        String jam = terima.getStringExtra("varJam");
        String nomor = terima.getStringExtra("varNomor");
        String status = terima.getStringExtra("varStatus");
        String tanggalStatus = terima.getStringExtra("varTanggalStatus");
        int foto = terima.getIntExtra("1", 0);

        tvNomor.setText(nomor);
        tvStatus.setText(status);
        tvTanggalStatus.setText(tanggalStatus);

        tvNama.setText(nama);
        Glide.with(DetailChatActivity.this)
                .load(foto)
                .into(iFoto);
        tvChat.setText(chat);
        tvJam.setText(jam);

        RecyclerView rvDetailChat = findViewById(R.id.rv_detailchat);
        rvDetailChat.setHasFixedSize(true);
        rvDetailChat.setLayoutManager(new LinearLayoutManager(this));
//        if (DataDetailChat.detailChats.size() == 3) {
//
//            DataDetailChat.detailChats.add(new DetailChat(chat, jam));
//
//        } else {
//            DataDetailChat.detailChats.remove(DataDetailChat.detailChats.size() - 1);
//            DataDetailChat.detailChats.add(new DetailChat(chat, jam));
//
//        }
        AdapterDetailChat adapter = new AdapterDetailChat(DataDetailChat.detailChats);
        rvDetailChat.setAdapter(adapter);
    }

    public void profil(View view) {
        String nama = tvNama.getText().toString();
        String nomor = tvNomor.getText().toString();
        String status = tvStatus.getText().toString();
        String tanggalStatus = tvTanggalStatus.getText().toString();
//        int foto = iFoto.getDrawable().;
        Intent profil = new Intent(DetailChatActivity.this, ProfilActivity.class);
        profil.putExtra("varNama", nama);
        profil.putExtra("varNomor", nomor);
        profil.putExtra("varStatus", status);
        profil.putExtra("varTanggalStatus", tanggalStatus);
        int foto = getIntent().getIntExtra("1", 0);
        profil.putExtra("1", foto);
        startActivity(profil);
    }

    public void back(View view) {
        Intent back = new Intent(DetailChatActivity.this, MainActivity.class);
        startActivity(back);
    }
}