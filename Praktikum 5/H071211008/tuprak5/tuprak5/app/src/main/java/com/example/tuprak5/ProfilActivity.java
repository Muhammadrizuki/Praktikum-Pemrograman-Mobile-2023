package com.example.tuprak5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(ProfilFragment.class.getSimpleName());
        if (!(fragment instanceof ProfilFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frameLayout, new ProfilFragment(), ProfilFragment.class.getSimpleName())
                    .commit();
        }
    }
}