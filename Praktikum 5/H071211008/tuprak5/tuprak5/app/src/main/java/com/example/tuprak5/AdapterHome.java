package com.example.tuprak5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder>{

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
        String caption = dataitem.get(position).getCaption();
        Bitmap foto = dataitem.get(position).getFoto();

        holder.iv_foto.setImageBitmap(foto);
        holder.tv_caption.setText(caption);

        holder.iv_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfilActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_foto, iv_profil;
        TextView tv_caption;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto = itemView.findViewById(R.id.iv_poto);
            tv_caption = itemView.findViewById(R.id.tv_caption);
            iv_profil = itemView.findViewById(R.id.iv_profil);
        }
    }
}
