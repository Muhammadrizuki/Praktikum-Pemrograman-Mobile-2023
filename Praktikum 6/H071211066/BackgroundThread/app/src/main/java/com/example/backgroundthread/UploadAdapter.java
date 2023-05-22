package com.example.backgroundthread;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class UploadAdapter extends RecyclerView.Adapter<UploadAdapter.ViewHolder> {

    Context context;
    ArrayList<UploadModel> uploads;

    public UploadAdapter(Context context, ArrayList<UploadModel> uploads) {
        this.context = context;
        this.uploads = uploads;
    }

    @NonNull
    @Override
    public UploadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_upload, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UploadAdapter.ViewHolder holder, int position) {
        holder.tCapt.setText(uploads.get(position).getCaption());
        String nama = uploads.get(position).getNama();
        String username = uploads.get(position).getUsername();
        String foto = uploads.get(position).getProfile();
        Glide.with(holder.itemView.getContext())
                .load(foto)
                .apply(new RequestOptions().override(350,
                        550))
                .into(holder.profile);
        Glide.with(holder.itemView.getContext())
                .load(uploads.get(position).getUri())
                .apply(new RequestOptions().override(350,
                        550))
                .into(holder.post);
        holder.tUNama.setText(username);
        holder.pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra(ProfileActivity.EXTRA_NAMA, nama);
                intent.putExtra(ProfileActivity.EXTRA_USERNAME, username);
                intent.putExtra(ProfileActivity.EXTRA_FOTO, foto);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tCapt, tUNama;
        ImageView post, profile;
        LinearLayout pr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tCapt = itemView.findViewById(R.id.tCapt);
            post = itemView.findViewById(R.id.post);
            pr = itemView.findViewById(R.id.pr);
            profile = itemView.findViewById(R.id.profile);
            tUNama = itemView.findViewById(R.id.tUNama);
        }
    }
}
