package com.example.backgroundthread;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

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
        holder.tNama.setText(uploads.get(position).getNama());
        holder.tUNama.setText(uploads.get(position).getUsername());
        Glide.with(holder.itemView.getContext())
                .load(uploads.get(position).getProfile())
                .apply(new RequestOptions().override(350,
                        550))
                .into(holder.profile);
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView profile;
        TextView tNama, tUNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            tNama = itemView.findViewById(R.id.tNama);
            tUNama = itemView.findViewById(R.id.tUNama);
        }
    }
    void setFilter(ArrayList<UploadModel> filterModel){
//        uploads = new ArrayList<>();
//        uploads.addAll(filterModel);
        this.uploads = filterModel;
        notifyDataSetChanged();
    }
}
