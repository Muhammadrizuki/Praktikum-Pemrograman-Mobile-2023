package com.example.tuprak6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv_home, iv_post, iv_profil, iv_cari;
    private TextView tv_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_home = findViewById(R.id.iv_home);
        iv_post = findViewById(R.id.iv_post);
        iv_profil = findViewById(R.id.iv_profil);
        iv_cari = findViewById(R.id.iv_cari);
        tv_toolbar = findViewById(R.id.tv_toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment =
                fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frameLayout, homeFragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        }

        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new HomeFragment());
            }
        });

        iv_cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SearchFragment());
            }
        });

        iv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PostFragment());
            }
        });

        iv_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ProfilFragment());
            }
        });
    }

    void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

        if (fragment instanceof HomeFragment){
            tv_toolbar.setText("IniInstaGram");
        }
        if (fragment instanceof SearchFragment){
            tv_toolbar.setText("SearchGram");
        }
        if (fragment instanceof PostFragment){
            tv_toolbar.setText("PostGram");
        }
        if (fragment instanceof ProfilFragment){
            tv_toolbar.setText("ProfilGram");
        }
    }
}