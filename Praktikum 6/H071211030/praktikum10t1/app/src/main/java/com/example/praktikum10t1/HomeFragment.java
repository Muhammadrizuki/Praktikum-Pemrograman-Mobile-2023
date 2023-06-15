package com.example.praktikum10t1;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rv_home;
    PostAdapter postAdapter;
    Parcelable post;
    User user;
    static ArrayList<User> postingan = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_home = view.findViewById(R.id.rv_postingan);
        rv_home.setHasFixedSize(true);
        rv_home.setLayoutManager(new LinearLayoutManager(getContext()));

        Bundle bundle = getArguments();
        if (bundle !=null){
            post = bundle.getParcelable("PhotoPost");
            user = new User("Muhammad Ikram Hidayat", "ramstuy", R.drawable.log, (Post) post);
            postingan.add(user);
        }

        if(postingan.isEmpty()){
            Uri imageUri = Uri.parse("android.resource://"+getContext()+"/"+R.drawable.poto);
            Post post1 = new Post(imageUri, "Obsidian");
            user = new User("Montezuma Maiara", "montepemai", R.drawable.poto, (Post) post1);
            postingan.add(user);
        }

        postAdapter = new PostAdapter(postingan);
        rv_home.setAdapter(postAdapter);
    }

}