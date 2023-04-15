package com.example.tuprak4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_nama, user2;
    TextView tv_back;
    ShapeableImageView iv_profil;
    RecyclerView rv_roomchat;
    RecyclerView.Adapter rvr_Adapter;
    RecyclerView.LayoutManager rvr_LManager;
    private ArrayList<ModelRoomChat> data = new ArrayList<>();
    TampilanChat tampilanChat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_nama = findViewById(R.id.tv_nama);
        iv_profil = findViewById(R.id.iv_profil);
        tv_back = findViewById(R.id.tv_back);
//        user2 = findViewById(R.id.tv_user2);

        rv_roomchat = findViewById(R.id.rv_roomchat);
        rv_roomchat.setHasFixedSize(true);

        rvr_LManager = new LinearLayoutManager(this);
        rv_roomchat.setLayoutManager(rvr_LManager);
        rv_roomchat.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        rvr_Adapter =  new AdapterRoomChat(data);
        rv_roomchat.setAdapter(rvr_Adapter);

        Intent terima = getIntent();
        String nama = terima.getStringExtra("nama");
        String isichat = terima.getStringExtra("isichat");
        String profil = terima.getStringExtra("profil");
        String nohp = terima.getStringExtra("nohp");
        String status = terima.getStringExtra("status");
        String tanggal = terima.getStringExtra("tanggal");

        tv_nama.setText(nama);
        iv_profil.setImageResource(Integer.parseInt(profil));

        ModelRoomChat room = new ModelRoomChat("apaaja", isichat);
        data.addAll(TampilanRoomChat.getUser());
        data.add(room);
        rvr_Adapter =  new AdapterRoomChat(data);
        rv_roomchat.setAdapter(rvr_Adapter);

        iv_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("profil", profil);
                startActivity(intent);
            }
        });

        tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("profil", profil);
                intent.putExtra("nama", nama);
                intent.putExtra("nohp", nohp);
                intent.putExtra("status", status);
                intent.putExtra("tanggal", tanggal);
                startActivity(intent);
            }
        });
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, new Intent().putExtra("back", (CharSequence) tampilanChat));
                finish();
            }
        });
    }
}