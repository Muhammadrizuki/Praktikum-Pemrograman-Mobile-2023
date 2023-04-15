package com.example.tuprak4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRoomChat extends RecyclerView.Adapter<AdapterRoomChat.ViewHolder> {

    private ArrayList<ModelRoomChat> dataroomchat;

    AdapterRoomChat(ArrayList<ModelRoomChat> dataroomchat){
        this.dataroomchat = dataroomchat;
    }

    @NonNull
    @Override
    public AdapterRoomChat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_roomchat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRoomChat.ViewHolder holder, int position) {
        ModelRoomChat room = dataroomchat.get(position);
        holder.tv_user1.setText(room.getUser1());
        holder.tv_user2.setText(room.getUser2());
    }

    @Override
    public int getItemCount() {
        return dataroomchat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_user1, tv_user2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_user1 = itemView.findViewById(R.id.tv_user1);
            tv_user2 = itemView.findViewById(R.id.tv_user2);
        }
    }
}
