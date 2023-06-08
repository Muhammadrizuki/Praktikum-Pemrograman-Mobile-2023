package com.example.tuprak6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.ViewHolder>{
    private ArrayList<User> dataSearch;

    public AdapterSearch(List<User> dataSearch) {
        this.dataSearch = (ArrayList<User>) dataSearch;
    }
    public void setFilteredList(ArrayList<User> filteredList) {
        dataSearch = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterSearch.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSearch.ViewHolder holder, int position) {
        User user = dataSearch.get(position);
        holder.tv_nama.setText(user.getNama());
        holder.tv_username.setText(user.getUsername());
        Glide.with(holder.iv_profil).load(user.getProfil()).into(holder.iv_profil);
    }

    @Override
    public int getItemCount() {
        return dataSearch.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_nama, tv_username;
        private ImageView iv_profil;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_username = itemView.findViewById(R.id.tv_username);
            iv_profil = itemView.findViewById(R.id.iv_profil);
        }
    }
}
