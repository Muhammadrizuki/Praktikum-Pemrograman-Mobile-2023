package com.sisfo.networkassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sisfo.networkassignment.http.ApiClient;
import com.sisfo.networkassignment.http.Response;
import com.sisfo.networkassignment.model.User;

import retrofit2.Call;
import retrofit2.Callback;

public class ProfileActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private CardView cvProfile;
    private ImageView ivAvatar;
    private TextView tvFullname, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        cvProfile = findViewById(R.id.profile_container);
        progressBar = findViewById(R.id.progress_bar);
        ivAvatar = findViewById(R.id.iv_avatar);
        tvFullname = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);

        int userId = getIntent().getIntExtra("USER", 1);
        Call<Response<User>> client = ApiClient.service().getUserById(userId);

        client.enqueue(new Callback<Response<User>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Response<User>> call, retrofit2.Response<Response<User>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        User user = response.body().getData();

                        Glide.with(ProfileActivity.this)
                                .load(user.getAvatarUrl())
                                .into(ivAvatar);
                        tvFullname.setText(user.getFirstName() + " " + user.getLastName());
                        tvEmail.setText(user.getEmail());

                        progressBar.setVisibility(ProgressBar.GONE);
                        cvProfile.setVisibility(CardView.VISIBLE);
                    }
                } else {
                    if (response.body() != null) {
                        Toast.makeText(ProfileActivity.this, "Something's wrong.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Response<User>> call, Throwable t) {
                System.out.println(t.getMessage());
                Toast.makeText(ProfileActivity.this, "Failed to load the profile.", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(ProgressBar.GONE);
            }
        });
    }
}