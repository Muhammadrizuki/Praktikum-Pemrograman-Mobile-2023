package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    LinearLayout tes;
    List<UserResponse> data;
    ProgressBar pb;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);
        tes = findViewById(R.id.test);

        RecyclerView rvProfile = findViewById(R.id.rv_profile);
        rvProfile.setHasFixedSize(true);
        rvProfile.setLayoutManager(new LinearLayoutManager(this));
        rvProfile.setVisibility(View.GONE);
        pb.setVisibility(View.VISIBLE);


        Call<DataResponse> client = ApiConfig.getApiService().getUser();
        client.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        data = response.body().getData();
                        ExecutorService executor = Executors.newSingleThreadExecutor();
                        Handler handler = new Handler(Looper.getMainLooper());
                        executor.execute(()->{
                            try {
                                Thread.sleep(500);
                                handler.post(()->{
                                    UserAdapter adapter = new UserAdapter(data);
                                    rvProfile.setAdapter(adapter);
                                    rvProfile.setVisibility(View.VISIBLE);
                                    pb.setVisibility(View.GONE);
                                });
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        });
                    }
                    for (UserResponse i: data) {
                        System.out.println(i.getFirstName());
                    }
                }

                else {
                    if (response.body() != null) {
                        Log.e("MainActivity", "onFailure: " + response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                pb.setVisibility(View.GONE);
                rvProfile.setVisibility(View.GONE);
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