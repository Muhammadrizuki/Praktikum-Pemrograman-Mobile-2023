package com.sisfo.networkassignment.model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sisfo.networkassignment.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private final List<User> users;
    private ClickListner clickListner;

    public UserAdapter() {
        users = new ArrayList<>();
    }

    public void addUsers(List<User> users) {
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    public void setClickListner(ClickListner clickListner) {
        this.clickListner = clickListner;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvFullname, tvEmail, tvId;
        private final ImageView ivAvatar;
        private final CardView cvUser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullname = itemView.findViewById(R.id.tv_full_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvId = itemView.findViewById(R.id.tv_id);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            cvUser = itemView.findViewById(R.id.cv_user);

        }

        @SuppressLint("SetTextI18n")
        public void bind(User user) {
            tvFullname.setText(user.getFirstName() + " " + user.getLastName());
            tvEmail.setText(user.getEmail());
            tvId.setText(String.valueOf(user.getId()));

            Glide.with(itemView.getContext()).load(user.getAvatarUrl()).into(ivAvatar);

            cvUser.setOnClickListener(v -> {
                clickListner.onClick(user);
            });
        }
    }

    public interface ClickListner {
        void onClick(User user);
    }
}
