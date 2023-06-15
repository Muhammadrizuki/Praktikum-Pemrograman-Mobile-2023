package com.example.tuprak5;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rv;
    RecyclerView.Adapter rv_adapter;
    private List<User> dataitem;
    private TextView tv_add;
    User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        rv = view.findViewById(R.id.rv);
        tv_add = view.findViewById(R.id.tv_add);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));

        dataitem = new ArrayList<>();
        Bundle bundle = getArguments();
        if (bundle != null){
            tv_add.setVisibility(View.GONE);
            System.out.println("dfhgh");

            user = (User) bundle.getParcelable("user");
            DataPost.setData(user);
        }
        dataitem = DataPost.getData();

        rv_adapter =  new AdapterHome(dataitem);
        rv.setAdapter(rv_adapter);
    }
}
