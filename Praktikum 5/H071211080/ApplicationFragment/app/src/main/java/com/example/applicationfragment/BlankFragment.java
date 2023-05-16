package com.example.applicationfragment;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    private ImageView add,profile,picture1;

    RecyclerView rv;

    TextView tv;

    CircleImageView picture;

    private TextView text1,text2;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_blank, container, false);


       add = view.findViewById(R.id.addicon);
       profile = view.findViewById(R.id.profileicon);
       rv = view.findViewById(R.id.recycle1);

         tv = view.findViewById(R.id.tv3);
        picture1 = view.findViewById(R.id.picture1);

        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        ArrayList<Parcable> listparcable = new ArrayList<>();
        viewModel.getData().observe(getViewLifecycleOwner(), new Observer<Parcable>() {
            @Override
            public void onChanged(Parcable parcable) {

                Bundle bundle = getArguments();
                    if (parcable != null) {
                        listparcable.add(parcable);
                    }
                }
        });



        Adapter adapter = new Adapter(listparcable);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment= new SecondFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container,secondFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThirdFragment thirdFragment = new ThirdFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container,thirdFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;

    }

}