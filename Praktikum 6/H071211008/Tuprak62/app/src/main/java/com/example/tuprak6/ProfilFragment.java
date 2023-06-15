package com.example.tuprak6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfilFragment extends Fragment {
    TextView tv_nama, tv_username;
    ImageView iv_profil;
    LinearLayout ll_loading;
    RelativeLayout rvvv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        tv_nama = view.findViewById(R.id.tv_nama);
        tv_username = view.findViewById(R.id.tv_username);
        iv_profil = view.findViewById(R.id.iv_profil);
        ll_loading = view.findViewById(R.id.llloading);
        rvvv = view.findViewById(R.id.rvvv);

        User user = null;
        if (getActivity().getIntent().getParcelableExtra("user") == null) {
            user = new User("Besse Sahriyuni","bshriyuni", user.getProfil());
        }else {
            user = getActivity().getIntent().getParcelableExtra("user");
            ll_loading.setVisibility(View.VISIBLE);
            rvvv.setVisibility(View.GONE);

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            executor.execute(() -> {
                try {
                    //simulate process in background thread
                    Thread.sleep(2000);

                    handler.post(() -> {
                        //update ui in main thread
                        ll_loading.setVisibility(View.GONE);
                        rvvv.setVisibility(View.VISIBLE);

                    });
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        tv_nama.setText(user.getNama());
        tv_username.setText(user.getUsername());
        Glide.with(ProfilFragment.this).load(user.getProfil()).into(iv_profil);

    }
}