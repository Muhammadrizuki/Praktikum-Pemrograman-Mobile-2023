package com.sisfo.networkassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sisfo.networkassignment.http.ApiClient;
import com.sisfo.networkassignment.http.Response;
import com.sisfo.networkassignment.model.User;
import com.sisfo.networkassignment.model.UserAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private final UserAdapter adapter = new UserAdapter();
    private RecyclerView rvUsers;
    private ProgressBar progressBar;
    private Button btnReload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUsers = findViewById(R.id.rv_users);
        progressBar = findViewById(R.id.progress_bar);
        btnReload = findViewById(R.id.button_reload);

        fetchStart(1, adapter);
        fetchStart(2, adapter);

        initiateReload(btnReload);
    }

    private void fetchStart(int pageNumber, UserAdapter adapter) {
        Call<Response<List<User>>> client = ApiClient.service().getUserPerPage(pageNumber);

        client.enqueue(new Callback<Response<List<User>>>() {
            @Override
            public void onResponse(Call<Response<List<User>>> call, retrofit2.Response<Response<List<User>>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<User> users = response.body().getData();
                        adapter.addUsers(users);
                        adapter.setClickListner(user -> {
                            Intent toProfile = new Intent(MainActivity.this, ProfileActivity.class);
                            toProfile.putExtra("USER", user.getId());
                            startActivity(toProfile);
                        });
                        rvUsers.setAdapter(adapter);
                        rvUsers.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        fetchDone(true);
                    }
                } else {
                    if (response.body() != null) {
                        fetchDone(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<Response<List<User>>> call, Throwable t) {
                fetchDone(false);
            }
        });
    }

    private void fetchDone(Boolean success) {
        if (!success) {
            Toast.makeText(MainActivity.this, "Failed to fetch the data, check your connection again.", Toast.LENGTH_SHORT).show();
            btnReload.setVisibility(View.VISIBLE);
        }
        progressBar.setVisibility(View.GONE);
    }

    private void initiateReload(Button btnReload) {
        btnReload.setOnClickListener(v -> {
            fetchStart(1, adapter);
            fetchStart(2, adapter);
            v.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        });
    }
}