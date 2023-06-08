package com.example.tuprak6;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.transition.MaterialElevationScale;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {
    private SearchView sv_cari;
    RecyclerView rv_search;
    RecyclerView.Adapter rv_Adapter;
    private ProgressBar progressBar;
    private ArrayList<User> dataSearch;
    private AdapterSearch adapterSearch;
    private Executor executor;
    private Handler handler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        sv_cari = view.findViewById(R.id.sv_cari);
        rv_search = view.findViewById(R.id.rv_search);

        rv_search.setHasFixedSize(true);
        rv_search.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_search.addItemDecoration(new DividerItemDecoration(rv_search.getContext(), DividerItemDecoration.VERTICAL));

        progressBar = view.findViewById(R.id.progressBar);

        dataSearch = Search.dataa;
        adapterSearch = new AdapterSearch(dataSearch);

        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

        sv_cari.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(final String newText) {
                handler.removeCallbacksAndMessages(null); // Membatalkan penundaan sebelumnya jika ada
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        executor.execute(new Runnable() {
                            @Override
                            public void run() {
                                filterList(newText);
                            }
                        });
                    }
                }, 2000); // Penundaan 5 detik (5000 milidetik)
                showProgressBar();
                rv_search.setVisibility(View.GONE);
                return true;
            }
        });
    }

    private void filterList(String text) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                hideProgressBar();
                if (TextUtils.isEmpty(text)) {
                    adapterSearch.setFilteredList(dataSearch);
                    rv_search.setVisibility(View.GONE);
                } else {
                    ArrayList<User> setFilteredList = new ArrayList<>();
                    for (User user : dataSearch) {
                        String query = text.toLowerCase();
                        String fullname = user.getNama().toLowerCase();
                        String username = user.getUsername().toLowerCase();

                        if (fullname.startsWith(query) || username.startsWith(query)) {
                            setFilteredList.add(user);
                        }
                    }
                    if (setFilteredList.isEmpty()) {
                        Toast.makeText(getActivity(), "Data not found", Toast.LENGTH_SHORT).show();
                        rv_search.setVisibility(View.GONE);
                    } else {
                        adapterSearch.setFilteredList(setFilteredList);
                        rv_Adapter = new AdapterSearch(setFilteredList);
                        rv_search.setAdapter(rv_Adapter);
                        rv_search.setVisibility(View.VISIBLE);
                    }
                }
                adapterSearch.notifyDataSetChanged(); // Perbarui tampilan setelah memperbarui daftar
            }
        });
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }
}