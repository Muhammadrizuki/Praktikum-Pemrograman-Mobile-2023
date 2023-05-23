package com.sisfo.tugaspraktikum7.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sisfo.tugaspraktikum7.databinding.ItemSearchBinding;
import com.sisfo.tugaspraktikum7.model.User;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<User> users;
    private ClickListener clickListener;

    public SearchAdapter(List<User> users) {
        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSearchBinding view = ItemSearchBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        holder.onBind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemSearchBinding binding;

        public ViewHolder(@NonNull ItemSearchBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(User user) {
            Glide.with(binding.getRoot().getContext())
                    .load(Uri.parse(user.getProfilePicture()))
                    .into(binding.ivProfilePicture);

            binding.tvFullname.setText(user.getFullName());
            binding.tvUsername.setText(user.getUsername());

            binding.getRoot().setOnClickListener(v -> clickListener.toProfile(user));
        }

    }

    public interface ClickListener {
        void toProfile(User user);
    }
}
