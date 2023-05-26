package com.example.networking;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<UserResponse> data;
    public UserAdapter(List<UserResponse> data){

        this.data = data;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        UserResponse userResponse = data.get(position);
        String id = String.valueOf(userResponse.getId());
        holder.tNama.setText(userResponse.getFirstName()+userResponse.getLastName());
        holder.tUNama.setText(userResponse.getEmail());
        Glide.with(holder.itemView.getContext())
                .load(userResponse.getAvatar())
                .apply(new RequestOptions().override(350,
                        550))
                .into(holder.profile);
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), SingleUserActivity.class);
                intent.putExtra(SingleUserActivity.EXTRA_ID, id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView profile;
        TextView tNama, tUNama;
        LinearLayout ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            tNama = itemView.findViewById(R.id.tNama);
            tUNama = itemView.findViewById(R.id.tUNama);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
