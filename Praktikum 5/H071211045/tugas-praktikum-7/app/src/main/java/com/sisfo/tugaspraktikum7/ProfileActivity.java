package com.sisfo.tugaspraktikum7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.sisfo.tugaspraktikum7.R;
import com.sisfo.tugaspraktikum7.fragments.ProfileFragment;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        FragmentManager fm = getSupportFragmentManager();

        ProfileFragment fragment = new ProfileFragment();

        fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
    }
}