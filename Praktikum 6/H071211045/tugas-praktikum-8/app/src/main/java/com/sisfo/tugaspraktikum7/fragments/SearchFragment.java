package com.sisfo.tugaspraktikum7.fragments;

import static com.sisfo.tugaspraktikum7.datasource.Storage.users;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.sisfo.tugaspraktikum7.MainActivity;
import com.sisfo.tugaspraktikum7.ProfileActivity;
import com.sisfo.tugaspraktikum7.R;
import com.sisfo.tugaspraktikum7.adapter.SearchAdapter;
import com.sisfo.tugaspraktikum7.databinding.FragmentHomeBinding;
import com.sisfo.tugaspraktikum7.databinding.FragmentSearchBinding;
import com.sisfo.tugaspraktikum7.datasource.Storage;
import com.sisfo.tugaspraktikum7.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private SearchAdapter adapter;
    public SearchFragment() {/* Constructor */}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentSearchBinding.bind(view);

        adapter = new SearchAdapter(users);
        adapter.setClickListener((user) -> {
            Intent intent = new Intent(getContext(), ProfileActivity.class).putExtra("USER", user);
            startActivity(intent);
        });

        /* Search RV */
        binding.rvSearch.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvSearch.setAdapter(adapter);
        binding.rvSearch.setVisibility(View.GONE);

        /* Search Edit Text Form */
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {/* Do Nothing */}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                search(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {/* Do Nothing */}
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void search(CharSequence query) {
        load(true);

        Executor executor = runnable -> new Thread(runnable).start();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(() -> {
            try {
                Thread.sleep(400L);
                handler.post(() -> {
                    if (TextUtils.isEmpty(query)) {
                        adapter.setUsers(new ArrayList<>());
                    } else {
                        adapter.setUsers(findUser(query.toString()));
                    }
                    adapter.notifyDataSetChanged();
                    load(false);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void load(boolean isShown) {
        if (isShown) {
            this.binding.progressBar.setVisibility(View.VISIBLE);
            this.binding.rvSearch.setVisibility(View.INVISIBLE);
            return;
        }
        this.binding.progressBar.setVisibility(View.INVISIBLE);
        this.binding.rvSearch.setVisibility(View.VISIBLE);
    }

    public List<User> findUser(String query) {
        List<User> usersResult = new ArrayList<>();
        for (User user : users) {
            if (user.getUsername().toLowerCase().contains(query.toLowerCase())) {
                usersResult.add(user);
            }
        }
        return usersResult;
    }

}