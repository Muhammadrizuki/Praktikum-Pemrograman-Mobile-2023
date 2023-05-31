package com.example.tugas4mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterChats extends RecyclerView.Adapter<AdapterChats.ViewHolder> {

    private  List<ModelClass2> chatList;

    public  AdapterChats (List<ModelClass2> chatList){ this.chatList = chatList;}
    @NonNull
    @Override
    public AdapterChats.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design2,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChats.ViewHolder holder, int position) {
        String pesan = chatList.get(position).getPesan();
        String waktu = chatList.get(position).getWaktu();

        holder.SetData(pesan,waktu);

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
    public class ViewHolder extends  RecyclerView.ViewHolder{

        private TextView pesan,waktu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pesan = itemView.findViewById(R.id.pesan);
            waktu = itemView.findViewById(R.id.waktu);

        }

        public void SetData(String p, String w) {

            pesan.setText(p);
            waktu.setText(w);

        }
    }
}
