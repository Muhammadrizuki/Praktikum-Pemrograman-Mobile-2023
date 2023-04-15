package com.example.tuprak4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter rv_Adapter;
    ArrayList<ModelTampilan> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));

        data = new ArrayList<>();
        for (int i = 0; i < TampilanChat.nama.length; i++){
            data.add(new ModelTampilan(
                    TampilanChat.nama[i],
                    TampilanChat.isiChat[i],
                    TampilanChat.time[i],
                    TampilanChat.profilList[i]));
        }

        rv_Adapter =  new AdapterChat(data);
        rv.setAdapter(rv_Adapter);
    }
}