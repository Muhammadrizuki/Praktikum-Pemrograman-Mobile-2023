package com.sisfo.localdatapersistent.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sisfo.localdatapersistent.databinding.ItemNoteBinding;
import com.sisfo.localdatapersistent.models.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private final ArrayList<Note> notes;
    private final ClickListener clickListener;

    public NoteAdapter(ClickListener clickListener) {
        this.notes = new ArrayList<>();
        this.clickListener = clickListener;
    }

    /* Setter and Getter */
    @SuppressLint("NotifyDataSetChanged")
    public void setNotes (ArrayList<Note> notes) {
        if (this.notes.size() > 0)
            this.notes.clear();

        this.notes.addAll(notes);
        notifyDataSetChanged();
    }

    public void addNote (Note note) {
        this.notes.add(note);
        notifyItemInserted(this.notes.size() - 1);
    }

    public void updateNote (int position, Note note) {
        this.notes.set(position, note);
        notifyItemChanged(position, note);
    }

    public void removeNote (int position) {
        this.notes.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.notes.size());
    }

    public ArrayList<Note> getNotes() {
        return this.notes;
    }
    /* End of 'Setter and Getter' */

    /* RecyclerView */
    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNoteBinding binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(notes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemNoteBinding binding;
        public ViewHolder(ItemNoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Note note, int position) {
            binding.tvTitle.setText(note.getTitle());
            binding.tvDesc.setText(note.getDescription());
            binding.tvCreatedAt.setText(note.getDate());

            binding.getRoot().setOnClickListener(view ->
                    clickListener.onItemClicked(note, position)
            );
        }
    }

    /* End of 'RecyclerView' */

    public interface ClickListener {
        void onItemClicked(Note note, int position);
    }

}

