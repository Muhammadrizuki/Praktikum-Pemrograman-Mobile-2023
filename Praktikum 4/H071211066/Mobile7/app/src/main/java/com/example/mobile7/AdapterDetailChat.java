package com.example.mobile7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdapterDetailChat extends RecyclerView.Adapter<AdapterDetailChat.ViewHolder> {
    private ArrayList<DetailChat> detailChats;
    private static ViewHolder.ClickListener clickListener;

    public void setClickListener(ViewHolder.ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public AdapterDetailChat(ArrayList<DetailChat> detailChats) {
        this.detailChats = detailChats;
    }

    @NonNull
    @Override
    public AdapterDetailChat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_chat, parent, false);
        return new AdapterDetailChat.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDetailChat.ViewHolder holder, int position) {
        DetailChat detailChat = detailChats.get(position);
//        holder.setData(detailChat);
        holder.tvChat.setText(detailChat.getChat());
        holder.tvJam.setText(detailChat.getJam());
    }

    @Override
    public int getItemCount() {
        return detailChats.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvChat, tvJam;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChat = itemView.findViewById(R.id.chats);
            tvJam = itemView.findViewById(R.id.jams);
        }

//        public void setData(DetailChat detailChat) {
//            tvChat.setText(detailChat.getChat());
//            tvJam.setText(detailChat.getJam());
//            System.out.println("tes" + tvChat);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    clickListener.onItemClicked(detailChat);
//                }
//            });
//        }
        interface ClickListener{

            void onItemClicked(DetailChat detailChat);

        }
    }
}
