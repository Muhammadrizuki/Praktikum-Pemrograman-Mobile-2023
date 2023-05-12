package com.sisfo.tugaspraktikum7.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sisfo.tugaspraktikum7.databinding.ItemPostBinding;
import com.sisfo.tugaspraktikum7.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Post> postList;
    ClickListener clickListener;

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding view = ItemPostBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.onBind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding binding;
        public ViewHolder(@NonNull ItemPostBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(Post post) {
            binding.tvFullName.setText("Hj. Muhammad Soeharto");
            binding.tvUsername.setText("mr_soeharto");
            binding.ivPostImage.setImageURI(post.getImage());
            binding.tvCaption.setText(post.getCaption());

            binding.tvFullName.setOnClickListener(v -> clickListener.toProfile());
            binding.tvUsername.setOnClickListener(v -> clickListener.toProfile());
            binding.ivProfilePicture.setOnClickListener(v -> clickListener.toProfile());
        }
    }

    public interface ClickListener {
        void toProfile();
    }
}
