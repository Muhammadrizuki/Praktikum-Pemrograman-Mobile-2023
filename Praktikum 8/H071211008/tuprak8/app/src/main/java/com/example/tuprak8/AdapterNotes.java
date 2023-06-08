package com.example.tuprak8;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.ViewHolder> {

    private ArrayList<Notes> dataitem = new ArrayList<>();

    public void setData(ArrayList<Notes> notesList) {
        dataitem.clear();
        if (notesList != null) {
            dataitem.addAll(notesList);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterNotes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotes.ViewHolder holder, int position) {
        Notes notes = dataitem.get(position);
        holder.tv_title.setText(notes.getTitle());
        holder.tv_description.setText(notes.getDescription());
        holder.tv_createdAt.setText(notes.getCreatedAt());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                if (notes != null){
                    intent.putExtra(MainActivity2.EXTRA_NOTES, notes);
                }
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title, tv_description, tv_createdAt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_des);
            tv_createdAt = itemView.findViewById(R.id.tv_createdAt);
        }
    }
}
