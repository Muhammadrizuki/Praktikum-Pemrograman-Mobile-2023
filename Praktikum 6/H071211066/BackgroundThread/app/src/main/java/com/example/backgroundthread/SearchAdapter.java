package com.example.backgroundthread;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
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
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    ArrayList<UploadModel> uploads;
    Context context;

    public SearchAdapter(Context context, ArrayList<UploadModel> uploads) {
        this.context = context;
        this.uploads = uploads;
    }
    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        String nama = uploads.get(position).getNama();
        String username = uploads.get(position).getUsername();
        String foto = uploads.get(position).getProfile();
        holder.tNama.setText(nama);
        holder.tUNama.setText(username);
        Glide.with(holder.itemView.getContext())
                .load(foto)
                .apply(new RequestOptions().override(350,
                        550))
                .into(holder.profile);
        holder.ll.setOnClickListener(new View.OnClickListener() {
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
    void setFilter(ArrayList<UploadModel> filterModel){
        this.uploads = filterModel;
        notifyDataSetChanged();
    }
}
