package com.example.mobile7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvChats = findViewById(R.id.rv_chats);
        rvChats.setHasFixedSize(true);
        rvChats.setLayoutManager(new LinearLayoutManager(this));
        rvChats.addItemDecoration(
                new DividerItemDecoration(rvChats.getContext(), DividerItemDecoration.VERTICAL)
        );

        AdapterChat adapter = new AdapterChat(DataChat.ambilDataChat());
        adapter.setClickListener(new AdapterChat.ClickListener() {
            @Override
            public void onItemClicked(ModelChat model) {
                Toast.makeText(MainActivity.this, model.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
        rvChats.setAdapter(adapter);
    }
}