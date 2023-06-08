package com.sisfo.tugaspraktikum7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.sisfo.tugaspraktikum7.R;
import com.sisfo.tugaspraktikum7.databinding.ActivityProfileBinding;
import com.sisfo.tugaspraktikum7.fragments.ProfileFragment;
import com.sisfo.tugaspraktikum7.model.User;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fm = getSupportFragmentManager();
        ProfileFragment fragment = new ProfileFragment();

        Bundle bundle = new Bundle();
        User user = getIntent().getParcelableExtra("USER");
        bundle.putParcelable("USER", user);

        Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(400L);
                    runOnUiThread(() -> {
                        binding.fragmentContainer.setVisibility(View.VISIBLE);
                        binding.progressBar.setVisibility(View.GONE);
                    });

                    fragment.setArguments(bundle);
                    fm.beginTransaction().add(R.id.fragment_container, fragment).commit();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        });

        thread.start();

    }

}