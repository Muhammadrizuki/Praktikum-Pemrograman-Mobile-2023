package com.example.applicationfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.adapterViewHolder> {
    private ArrayList<Parcable> listparcable;

    public Adapter(ArrayList<Parcable> listparcable){
        this.listparcable= listparcable;
    }

    @NonNull
    @Override
    public Adapter.adapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapter = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle,parent,false);
        adapterViewHolder adapterViewHolder = new adapterViewHolder(adapter);
        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapterViewHolder holder, int position) {
        Parcable parcable = listparcable.get(position);
        holder.tv1.setText(parcable.getText1());
        holder.image.setImageURI(parcable.getImageUri());

    }


    @Override
    public int getItemCount() {
        return listparcable.size();
    }

    public class adapterViewHolder extends RecyclerView.ViewHolder{

        private TextView  tv1;

        private ImageView image;

        public adapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv3);
            image = itemView.findViewById(R.id.picture1);
        }
    }
}
