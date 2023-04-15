package com.example.tuprak4;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.ViewHolder> {
    private ArrayList<ModelTampilan> dataItem;

    AdapterChat(ArrayList<ModelTampilan> dataItem){
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterChat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChat.ViewHolder holder, int position) {
        ModelTampilan tampilan = dataItem.get(position);
        holder.tv_nama.setText(tampilan.getNama());
        holder.tv_chat.setText(tampilan.getIsiChat());
        holder.tv_time.setText(tampilan.getTime());
        holder.iv_profil.setImageResource(tampilan.getProfil());
        String nohp = TampilanChat.nohp[position];
        String status = TampilanChat.status[position];
        String tanggal = TampilanChat.tanggal[position];

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = dataItem.get(holder.getAdapterPosition()).getNama();
                String isichat = dataItem.get(holder.getAdapterPosition()).getIsiChat();
                String profil = String.valueOf(dataItem.get(holder.getAdapterPosition()).getProfil());
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);

                intent.putExtra("nama", nama);
                intent.putExtra("isichat", isichat);
                intent.putExtra("profil", profil);
                intent.putExtra("nohp", nohp);
                intent.putExtra("status", status);
                intent.putExtra("tanggal", tanggal);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.iv_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = dataItem.get(holder.getAdapterPosition()).getNama();
                String profil = String.valueOf(dataItem.get(holder.getAdapterPosition()).getProfil());
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity4.class);

                intent.putExtra("nama", nama);
                intent.putExtra("profil", profil);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_chat, tv_time;
        ShapeableImageView iv_profil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_chat = itemView.findViewById(R.id.tv_cht);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_profil = itemView.findViewById(R.id.iv_profil);
        }

    }
}
