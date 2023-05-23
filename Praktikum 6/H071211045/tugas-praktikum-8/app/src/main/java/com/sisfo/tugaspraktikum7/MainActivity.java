package com.sisfo.tugaspraktikum7;

import static com.sisfo.tugaspraktikum7.datasource.Storage.users;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.gson.Gson;
import com.sisfo.tugaspraktikum7.databinding.ActivityMainBinding;
import com.sisfo.tugaspraktikum7.datasource.Storage;
import com.sisfo.tugaspraktikum7.fragments.AddFragment;
import com.sisfo.tugaspraktikum7.fragments.HomeFragment;
import com.sisfo.tugaspraktikum7.fragments.ProfileFragment;
import com.sisfo.tugaspraktikum7.fragments.SearchFragment;
import com.sisfo.tugaspraktikum7.model.Post;
import com.sisfo.tugaspraktikum7.model.User;
import com.sisfo.tugaspraktikum7.utilities.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        initiateNavButton();

        if (users.size() < 1) {
            this.initiateUserDummy(users);
            this.initiatePostDummy(users);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void initiateNavButton() {
        binding.cvHome.setOnClickListener(v -> {
            binding.tvTitle.setText("Inigaram");
            replaceFragment(new HomeFragment());
        });

        binding.cvSearch.setOnClickListener(v -> {
            binding.tvTitle.setText("Search");
            replaceFragment(new SearchFragment());
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

    private void initiateUserDummy(List<User> users) {
        Gson gson = new Gson();
        String usersJson = Utils.getJsonFromAssets(this, "users.json");
        Utils.UserList userDummy = gson.fromJson(usersJson, Utils.UserList.class);
        users.addAll(userDummy.list());
    }

    private void initiatePostDummy(List<User> userList) {
        List<Post> posts = new ArrayList<>();

        for (User user : userList) {
            Post newPost = new Post(user.getUsername(), user.getProfilePicture(), getString(R.string.caption_dummy));
            user.setPosts(posts);
            user.addPost(newPost);

            Storage.posts.add(newPost);
        }
    }
}