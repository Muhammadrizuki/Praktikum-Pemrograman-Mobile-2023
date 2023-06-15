package com.example.tuprak6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private ArrayList<User> dataitem;
    public AdapterHome(List<User> dataitem) {
        this.dataitem = (ArrayList<User>) dataitem;
    }

    @NonNull
    @Override
    public AdapterHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHome.ViewHolder holder, int position) {
        User user = dataitem.get(position);
        holder.tv_nama.setText(user.getNama());
        holder.tv_caption.setText(user.getCaption());
        holder.tv_username.setText(user.getUsername());

        Glide.with(holder.iv_foto).load(user.getPostingan()).into(holder.iv_foto);
        Glide.with(holder.iv_profil).load(user.getProfil()).into(holder.iv_profil);

        holder.iv_profil.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent((holder.itemView.getContext()), ProfilActivity.class);
               intent.putExtra("user", user);
               holder.itemView.getContext().startActivity(intent);
           }
        });
    }

    @Override
    public int getItemCount() {
        return  dataitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_foto, iv_profil;
        TextView tv_caption, tv_nama, tv_username;
        RelativeLayout rl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto = itemView.findViewById(R.id.iv_poto);
            tv_caption = itemView.findViewById(R.id.tv_caption);
            iv_profil = itemView.findViewById(R.id.iv_profil);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_username = itemView.findViewById(R.id.tv_username);
            rl = itemView.findViewById(R.id.rl);
        }
    }
}
