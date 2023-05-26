package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "extra_id";
    ShapeableImageView pp;
    TextView nama, username;
    LinearLayout profile, tes;
    ProgressBar pb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);

        pp = findViewById(R.id.pp);
        username = findViewById(R.id.username);
        nama = findViewById(R.id.nama);
        profile = findViewById(R.id.profile);
        pb = findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);
        profile.setVisibility(View.GONE);
        tes = findViewById(R.id.test);

        String did = getIntent().getStringExtra(EXTRA_ID);

        Call<DataResponse2> client = ApiConfig.getApiService().getUser2(did);
        client.enqueue(new Callback<DataResponse2>() {
            @Override
            public void onResponse(Call<DataResponse2> call, Response<DataResponse2> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        UserResponse userResponse = response.body().getData();
                        ExecutorService executor = Executors.newSingleThreadExecutor();
                        Handler handler = new Handler(Looper.getMainLooper());
                        executor.execute(()->{
                            try {
                                Thread.sleep(500);
                                handler.post(()->{
                                    pb.setVisibility(View.GONE);
                                    profile.setVisibility(View.VISIBLE);
                                    String dnama = userResponse.getFirstName() + " " + userResponse.getLastName();
                                    nama.setText(dnama);
                                    username.setText(userResponse.getEmail());
                                    Glide.with(SingleUserActivity.this)
                                        .load(userResponse.getAvatar())
                                        .into(pp);
                                });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });

                    }
                }
                else {
                    if (response.body() != null) {
                        Log.e("SingleUserActivity", "onFailure: " + response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResponse2> call, Throwable t) {
                pb.setVisibility(View.GONE);
                tes.setVisibility(View.VISIBLE);
                Log.e("MainActivity", "onFailure: " + t.getMessage());
            }
        });
    }
    public void rf(View view) {
        onRestart();
    }
    protected void onRestart() {
        super.onRestart();
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
}