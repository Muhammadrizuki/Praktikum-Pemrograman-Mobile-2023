package com.example.backgroundthread;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        TextView text = view.findViewById(R.id.text);

        ArrayList<UploadModel> uploads = DataUpload.getList();
        RecyclerView rvUploads = view.findViewById(R.id.rv_upload);
        rvUploads.setHasFixedSize(true);
        rvUploads.setLayoutManager(new LinearLayoutManager(getActivity()));
        UploadAdapter adapter = new UploadAdapter(getContext(), uploads);
        rvUploads.setAdapter(adapter);
        text.setVisibility(view.GONE);
    }
}