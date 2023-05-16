package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView appBar = findViewById(R.id.appbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        }
        ImageView add = findViewById(R.id.add);
        add.setOnClickListener(add_->{
            appBar.setText("Upload");
            UploadFragment uploadFragment = new UploadFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, uploadFragment,
                            UploadFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        });
        ImageView profile = findViewById(R.id.profile);
        profile.setOnClickListener(profile_->{
            appBar.setText("Profile");
            ProfileFragment profileFragment = new ProfileFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, profileFragment,
                            ProfileFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        });
        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(home_ -> {
            Bundle bundle = getIntent().getExtras();
            homeFragment.setArguments(bundle);
            appBar.setText("Syifgram");
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment,
                            HomeFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        });
    }
}