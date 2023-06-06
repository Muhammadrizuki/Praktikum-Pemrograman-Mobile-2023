package com.example.applicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SharedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        BlankFragment homeFragment = new BlankFragment();
        Fragment fragment =
                fragmentManager.findFragmentByTag(BlankFragment.class.getSimpleName());
        if (!(fragment instanceof BlankFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment,
                            BlankFragment.class.getSimpleName())
                    .commit();
        }
    }
}