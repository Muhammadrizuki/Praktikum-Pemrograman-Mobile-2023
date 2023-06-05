package com.example.networkassigment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";
    private ProgressBar progressBar;

    private LinearLayout RetryIcon;
    private CardView cardview;
    private TextView nama, email;

    private Handler handler;
    private ImageView profile;

    private ImageView Retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nama = findViewById(R.id.nameuser);
        Retry = findViewById(R.id.retry);
        email = findViewById(R.id.emailuser);
        profile = findViewById(R.id.Profile);
        RetryIcon = findViewById(R.id.retryicon);
        progressBar = findViewById(R.id.pb1);
        cardview = findViewById(R.id.card);


        loading();

        getDataApi();
    }

    void loading(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            try { //simulate process in background thread
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(100); int percentage = i * 10;
                    handler.post(() -> {
                        //update ui in main thread
                        if (percentage == 100) {
                            progressBar.setVisibility(View.GONE);
                            cardview.setVisibility(View.VISIBLE);
                        } else {
                            progressBar.setVisibility(View.VISIBLE);
                            cardview.setVisibility(View.GONE);
                        }
                    });
                }
            } catch (InterruptedException e) { e.printStackTrace(); } });

    }

    void getDataApi(){
        if (isNetworkAvailable()) {
            progressBar.setVisibility(View.VISIBLE);
            RetryIcon.setVisibility(View.GONE);
            cardview.setVisibility(View.VISIBLE);

            //ini juga mengambil data dari reqres.in tetapi hanya id nya saja
            String id = getIntent().getStringExtra("id");
            Call<Data2> client2 = ApiConfig.getApiService().getUser2(id);
            client2.enqueue(new Callback<Data2>() {
                @Override
                public void onResponse(Call<Data2> call, Response<Data2> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            User userResponse = response.body().getData();
                            String fullName = userResponse.getFirstName() + " " + userResponse.getLastName();
                            nama.setText(fullName);
                            email.setText(userResponse.getEmail());
                            Glide.with(Profile.this)
                                    .load(userResponse.getAvatarUrl())
                                    .into(profile);
//                        System.out.println("testing "+userResponse.getLastName());

                        } else {
                            if (response.body() != null) {
                                Log.e("DetailProfile", "onFailure: " + response.message());
                            }
                        }
                        System.out.println("testing ");
                    }
                }

                @Override
                public void onFailure(Call<Data2> call, Throwable t) {
                    Toast.makeText(Profile.this, "Unable to fetch data!", Toast.LENGTH_SHORT).show();

                }
            });
        }else {
            retry();
        }
    }
    private void retry() {
        RetryIcon.setVisibility(View.VISIBLE);
        cardview.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        Handler handler = new Handler();
        Retry.setOnClickListener(view -> {
            RetryIcon.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            cardview.setVisibility(View.GONE);
            handler.postDelayed(() -> {
                progressBar.setVisibility(View.GONE);
                getDataApi();
            }, 500);

        });
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
