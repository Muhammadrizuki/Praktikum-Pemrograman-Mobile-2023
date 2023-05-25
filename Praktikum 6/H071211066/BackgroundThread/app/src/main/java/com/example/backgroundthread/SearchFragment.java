package com.example.backgroundthread;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {
    SearchView searchView;
    ArrayList<UploadModel> uploads;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView = (SearchView) view.findViewById(R.id.cari);
        searchView.clearFocus();
        ProgressBar pb = view.findViewById(R.id.pb);
        String tes = String.valueOf(searchView.getQuery());
        RecyclerView rv = view.findViewById(R.id.rv_profile);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                pb.setVisibility(View.VISIBLE);
                rv.setVisibility(View.GONE);
                if (newText.isEmpty()){
                    rv.setVisibility(View.GONE);
                }
                filterList(newText);
                return true;
            }

            ArrayList<UploadModel> uploads = DataUpload.getList();
            SearchAdapter adapter = new SearchAdapter(getContext(), uploads);

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            private void filterList(String text) {
                ArrayList<UploadModel> filteredList = new ArrayList<>();
                for (UploadModel uploadModel : uploads) {
                    if (uploadModel.getUsername().toLowerCase().contains(text.toLowerCase())) {
                        filteredList.add(uploadModel);
                    }
                    if (filteredList.isEmpty()){
                        continue;
                    }else if(text.equals("")){
                        executor.execute(()->{
                            try {
                                Thread.sleep(500);
                                handler.post(()->{
                                    pb.setVisibility(View.GONE);
                                });
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        });
                    }
                    else {
                        adapter.setFilter(filteredList);
                        executor.execute(()->{
                            try {
                                Thread.sleep(500);
                                handler.post(()->{
                                    rv.setVisibility(View.VISIBLE);
                                    pb.setVisibility(View.GONE);
                                    rv.setAdapter(adapter);
                                });
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        });
                    }
                }
            }
        });
    }
}