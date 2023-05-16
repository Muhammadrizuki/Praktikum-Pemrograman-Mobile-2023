package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_uplod, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UploadAdapter.ViewHolder holder, int position) {
        holder.tCapt.setText(uploads.get(position).getCaption());
        holder.post.setImageURI(uploads.get(position).getUri());
        holder.pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tCapt;
        ImageView post;
        LinearLayout pr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tCapt = itemView.findViewById(R.id.tCapt);
            post = itemView.findViewById(R.id.post);
            pr = itemView.findViewById(R.id.pr);
        }
    }
}
