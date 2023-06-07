package com.example.localdatapersistent;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    ArrayList<NoteModel> noteModels;
    public NoteAdapter(ArrayList<NoteModel> note){
        this.noteModels = note;
    }
    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        NoteModel noteModel = noteModels.get(position);
        holder.tvJudul.setText(noteModel.getJudul());
        holder.tvWaktu.setText(noteModel.getWaktu());
        holder.tvDesk.setText(noteModel.getDeskripsi());
        holder.ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toForm = new Intent(holder.itemView.getContext(), FormActivity.class);
                if (noteModel != null) {
                    toForm.putExtra(FormActivity.EXTRA_NOTE, noteModel);
                }
                holder.itemView.getContext().startActivity(toForm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvWaktu, tvDesk;
        LinearLayout ly;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvWaktu = itemView.findViewById(R.id.tv_waktu);
            tvDesk = itemView.findViewById(R.id.tv_deskripsi);
            ly = itemView.findViewById(R.id.ly);
        }
    }
}
