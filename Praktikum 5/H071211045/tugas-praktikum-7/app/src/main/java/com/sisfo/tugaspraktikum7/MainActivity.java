package com.sisfo.tugaspraktikum7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.sisfo.tugaspraktikum7.databinding.ActivityMainBinding;
import com.sisfo.tugaspraktikum7.fragments.AddFragment;
import com.sisfo.tugaspraktikum7.fragments.HomeFragment;
import com.sisfo.tugaspraktikum7.fragments.ProfileFragment;
import com.sisfo.tugaspraktikum7.model.Post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;
    private List<Post> postList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.cvHome.setOnClickListener(v -> {
            binding.tvTitle.setText("Inigaram");
            replaceFragment(new HomeFragment());
        });

        binding.cvAdd.setOnClickListener(v -> {
            binding.tvTitle.setText("Upload");
            replaceFragment(new AddFragment());
        });

        binding.cvProfile.setOnClickListener(v -> {
            binding.tvTitle.setText("Profile");
            replaceFragment(new ProfileFragment());
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    public void addPost(Post post) {
        postList.add(post);
        Collections.reverse(postList);
    }

    public List<Post> getPostList() {
        return postList;
    }
}