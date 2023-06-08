package com.example.tuprak7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    private TextView tv_nama, tv_email;
    private ImageView iv_profil;
    private ProgressBar progressBar;
    private CardView cv;
    private LinearLayout ll_reload;
    private ImageView iv_loading;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_nama = findViewById(R.id.tv_nama);
        tv_email = findViewById(R.id.tv_email);
        iv_profil = findViewById(R.id.iv_profil);
        progressBar = findViewById(R.id.progressBar);
        cv = findViewById(R.id.cv);
        ll_reload = findViewById(R.id.reload);
        iv_loading = findViewById(R.id.loading);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        progressBar.setVisibility(View.VISIBLE);
        ll_reload.setVisibility(View.GONE);
        cv.setVisibility(View.GONE);

        fetchAPI(id);
        iv_loading.setOnClickListener(view -> {
            fetchAPI(id);
        });
    }

    private void fetchAPI(String id) {
        if (NetworkUtil.isNetworkAvailable(this)){
            ApiConfig.getApiService().getProfilById(id).enqueue(new Callback<Profil>() {
                @Override
                public void onResponse(Call<Profil> call, Response<Profil> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        System.out.println(response.body().getProfil());
                        UserResponse userResponse = response.body().getProfil();

                        tv_nama.setText(userResponse.getFirst_name() + " " + userResponse.getLast_name());
                        tv_email.setText(userResponse.getEmail());
                        Glide.with(MainActivity2.this).load(userResponse.getAvatarImg()).into(iv_profil);

                        progressBar.setVisibility(View.GONE);
                        cv.setVisibility(View.VISIBLE);
                        ll_reload.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<Profil> call, Throwable t) {
                    Toast.makeText(MainActivity2.this, "OnFailure " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            ll_reload.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            cv.setVisibility(View.GONE);
        }
    }
}