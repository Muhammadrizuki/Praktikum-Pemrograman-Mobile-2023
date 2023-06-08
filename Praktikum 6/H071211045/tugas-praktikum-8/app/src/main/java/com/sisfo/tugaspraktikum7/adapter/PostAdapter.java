package com.sisfo.tugaspraktikum7.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.sisfo.tugaspraktikum7.R;
import com.sisfo.tugaspraktikum7.databinding.ItemPostBinding;
import com.sisfo.tugaspraktikum7.datasource.Storage;
import com.sisfo.tugaspraktikum7.model.Post;
import com.sisfo.tugaspraktikum7.model.User;
import com.sisfo.tugaspraktikum7.utilities.Utils;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private final List<Post> posts;
    private ClickListener clickListener;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
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
        holder.onBind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemPostBinding binding;

        public ViewHolder(@NonNull ItemPostBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(Post post) {
            User user = findUserByUsername(post.getUsername());

            if (user != null) {
                this.fetchUser(user);

                if (user.getProfilePicture() != null) {
                    this.placeImage(user.getProfilePicture(), binding.ivProfilePicture, binding.shProfilePicture);
                    this.placeImage(post.getImage(), binding.ivPostImage, binding.shPostImage);
                }

                binding.tvCaption.setText(post.getCaption());
            }

            binding.tvFullName.setOnClickListener(v -> clickListener.toProfile(user));
            binding.tvUsername.setOnClickListener(v -> clickListener.toProfile(user));
            binding.ivProfilePicture.setOnClickListener(v -> clickListener.toProfile(user));
        }

        private void fetchUser(User user) {
            binding.tvFullName.setText(user.getFullName());
            binding.tvFullName.setText(user.getFullName());
            binding.tvUsername.setText(user.getUsername());
        }

        private User findUserByUsername(String username) {
            for (User user : Storage.users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }

        private void placeImage(String imageUrl, ImageView placeholder, ShimmerFrameLayout shimmerFrame) {
            shimmerFrame.startShimmer();
            Glide.with(binding.getRoot())
                    .load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(Utils.getDrawable(binding.getRoot().getContext(), R.drawable.round_image_24))
                    .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    shimmerFrame.stopShimmer();
                    shimmerFrame.hideShimmer();
                    Toast.makeText(binding.getRoot().getContext(), "Failed to load image", Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    shimmerFrame.stopShimmer();
                    shimmerFrame.hideShimmer();
                    return false;
                }

            }).into(placeholder);
        }
    }

    public interface ClickListener {
        void toProfile(User user);
    }
}
