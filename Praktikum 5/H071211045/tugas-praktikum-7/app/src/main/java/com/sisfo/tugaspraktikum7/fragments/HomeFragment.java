package com.sisfo.tugaspraktikum7.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sisfo.tugaspraktikum7.MainActivity;
import com.sisfo.tugaspraktikum7.adapter.PostAdapter;
import com.sisfo.tugaspraktikum7.databinding.FragmentHomeBinding;
import com.sisfo.tugaspraktikum7.model.Post;
import com.sisfo.tugaspraktikum7.ProfileActivity;

public class HomeFragment extends Fragment {

    private Post newPost;
    private FragmentHomeBinding binding;

    public HomeFragment() {/* Constructor */}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeBinding.bind(view);
        MainActivity parent = (MainActivity) getActivity();
        assert parent != null;

        if (getArguments() != null) {
            newPost = getArguments().getParcelable("POST");
            parent.addPost(newPost);
        }

        PostAdapter postAdapter = new PostAdapter(parent.getPostList());
        postAdapter.setClickListener(() -> {
            Intent intent = new Intent(getContext(), ProfileActivity.class);
            startActivity(intent);
        });

        if (parent.getPostList().size() > 0) {
            binding.rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvPosts.setAdapter(postAdapter);

        } else {
            binding.tvNoneDialogue.setVisibility(View.VISIBLE);
        }
    }
}