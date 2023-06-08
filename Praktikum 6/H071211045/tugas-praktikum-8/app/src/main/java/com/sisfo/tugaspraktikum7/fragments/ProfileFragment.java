package com.sisfo.tugaspraktikum7.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sisfo.tugaspraktikum7.R;
import com.sisfo.tugaspraktikum7.databinding.FragmentProfileBinding;
import com.sisfo.tugaspraktikum7.datasource.Account;
import com.sisfo.tugaspraktikum7.model.User;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    public ProfileFragment() {/* Constructor */}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentProfileBinding binding = FragmentProfileBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentProfileBinding.bind(view);

        User user;

        if (getArguments() != null)
            user = getArguments().getParcelable("USER");
        else
            user = Account.user;

        binding.tvFullname.setText(user.getFullName());
        binding.tvUsername.setText(user.getUsername());

        Glide.with(binding.getRoot())
                .load(user.getProfilePicture())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivProfilePicture);
    }
}