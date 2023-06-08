package com.example.tuprak7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private AdapterView adapterView;
    private LinearLayout ll_reload;
    private ImageView iv_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        ll_reload = findViewById(R.id.reload);
        iv_loading = findViewById(R.id.loading);
        adapterView = new AdapterView();

        ll_reload.setVisibility(View.GONE);

        fetchAPI();
        iv_loading.setOnClickListener(view -> {
            fetchAPI();
        });
    }

    private void fetchAPI() {
        if (NetworkUtil.isNetworkAvailable(this)){
            ApiConfig.getApiService().getUsers("12").enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful() && response.body() != null){

                        adapterView.addUser(response.body().getUsers());
                        ll_reload.setVisibility(View.GONE);
                        rv.setAdapter(adapterView);
                        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("MainActivity", "onFailure: " + t.getMessage());
                }
            });
        }
        else {
            ll_reload.setVisibility(View.VISIBLE);
            rv.setVisibility(View.VISIBLE);
        }
    }
}