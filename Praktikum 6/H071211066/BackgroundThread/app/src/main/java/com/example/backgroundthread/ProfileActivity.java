package com.example.backgroundthread;

import static com.example.backgroundthread.DataUpload.uploads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {
//    public static final String EXTRA_UPLOAD = "extra_upload";
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_USERNAME = "extra_username";
    public static final String EXTRA_FOTO = "extra_foto";
    ShapeableImageView pp;
    TextView nama, username;
    LinearLayout profile;
    ProgressBar pb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        pp = findViewById(R.id.pp);
        username = findViewById(R.id.username);
        nama = findViewById(R.id.nama);
        profile = findViewById(R.id.profile);
        pb = findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);
        profile.setVisibility(View.GONE);

       String dnama = getIntent().getStringExtra(EXTRA_NAMA);
       String dusername = getIntent().getStringExtra(EXTRA_USERNAME);
       String dfoto = getIntent().getStringExtra(EXTRA_FOTO);
        username.setText(dusername);
        nama.setText(dnama);
        Glide.with(ProfileActivity.this)
                .load(dfoto)
                .into(pp);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            try {
                Thread.sleep(2000);
                handler.post(()->{
                    profile.setVisibility(View.VISIBLE);
                    pb.setVisibility(View.GONE);
                });
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }
}