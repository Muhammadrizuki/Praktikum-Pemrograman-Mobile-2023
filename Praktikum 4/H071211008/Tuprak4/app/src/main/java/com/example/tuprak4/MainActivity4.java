package com.example.tuprak4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView tv_nama, tv_back;
    ImageView iv_profil;
    TampilanChat tampilanChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv_back = findViewById(R.id.tv_back);
        tv_nama = findViewById(R.id.tv_nama);
        iv_profil = findViewById(R.id.iv_profil);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String profil = intent.getStringExtra("profil");

        tv_nama.setText(nama);
        iv_profil.setImageResource(Integer.parseInt(profil));

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, new Intent().putExtra("back", (CharSequence) tampilanChat));
                finish();
            }
        });
    }
}