package com.example.tuprak7;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder> {
    private final ArrayList<UserResponse> dataitem = new ArrayList<>();
    public void addUser (List<UserResponse> dataitem) {
        this.dataitem.addAll(dataitem);
    }
    @NonNull
    @Override
    public AdapterView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterView.ViewHolder holder, int position) {
        UserResponse userResponse = dataitem.get(position);
        holder.tv_nama.setText(userResponse.getFirst_name() + " " + userResponse.getLast_name());
        holder.tv_email.setText(userResponse.getEmail());
        Glide.with(holder.iv_profil.getContext()).load(userResponse.getAvatarImg()).into(holder.iv_profil);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent((holder.itemView.getContext()), MainActivity2.class);
                intent.putExtra("id", String.valueOf(userResponse.getId()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nama, tv_email;
        ImageView iv_profil;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_email = itemView.findViewById(R.id.tv_email);
            iv_profil = itemView.findViewById(R.id.iv_profil);
        }
    }
}
