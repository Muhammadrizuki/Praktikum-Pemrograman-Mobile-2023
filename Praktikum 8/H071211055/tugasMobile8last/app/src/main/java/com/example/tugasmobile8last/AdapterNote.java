package com.example.tugasmobile8last;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterNote extends RecyclerView.Adapter<AdapterNote.ViewHolder> {
    private ArrayList<NoteModel> note;
    private Context context;

    public AdapterNote() {
        this.context = context;
        this.note = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteModel model = note.get(position);
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());
    }

    @Override
    public int getItemCount() {
        return note.size();
    }

    public void setData(ArrayList<NoteModel> notes) {
        note.clear();
        if (notes != null) {
            note.addAll(notes);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView desc;
        CardView item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            item = itemView.findViewById(R.id.itemNote);
            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                NoteModel clickedNote = note.get(position);
                Intent intent = new Intent(itemView.getContext(), MainActivity2.class);
                intent.putExtra(MainActivity2.EXTRA_NOTES, clickedNote);
                itemView.getContext().startActivity(intent);
            }
        }
    }
}
