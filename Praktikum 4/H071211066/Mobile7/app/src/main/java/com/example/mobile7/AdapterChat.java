package com.example.mobile7;

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

import java.util.ArrayList;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.ViewHolder> {
    private final ArrayList<ModelChat> dataChat;
    private ClickListener clickListener;

    public AdapterChat(ArrayList<ModelChat> dataChat) {

        this.dataChat = dataChat;
    }
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public interface ClickListener {
        void onItemClicked(ModelChat model);
    }

    @NonNull
    @Override
    public AdapterChat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_chats, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChat.ViewHolder holder, int position) {
        ModelChat model = dataChat.get(position);
        Glide.with(holder.itemView.getContext())
                        .load(model.getFoto())
                        .apply(new RequestOptions().override(100, 100))
                        .into(holder.iFoto);
        holder.tvNama.setText(model.getNama());
        holder.tvChat.setText(model.getChat());
        holder.tvJam.setText(model.getJam());
        holder.tvNomor.setText(model.getNomor());
        holder.tvStatus.setText(model.getStatus());
        holder.tvTanggalStatus.setText(model.getTanggalStatus());
        holder.iFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = dataChat.get(holder.getAdapterPosition()).getNama();
                int foto = dataChat.get(holder.getAdapterPosition()).getFoto();
                Intent kirim = new Intent(holder.itemView.getContext(), FotoActivity.class);
                kirim.putExtra("varNama", nama);
                kirim.putExtra("1", foto);

                holder.itemView.getContext().startActivity(kirim);
            }
        });
        holder.ly_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = dataChat.get(holder.getAdapterPosition()).getNama();
                String chat = dataChat.get(holder.getAdapterPosition()).getChat();
                String jam = dataChat.get(holder.getAdapterPosition()).getJam();
                String nomor = dataChat.get(holder.getAdapterPosition()).getNomor();
                String status = dataChat.get(holder.getAdapterPosition()).getStatus();
                String tanggalStatus = dataChat.get(holder.getAdapterPosition()).getTanggalStatus();
                int foto = dataChat.get(holder.getAdapterPosition()).getFoto();

                Intent kirim = new Intent(holder.itemView.getContext(), DetailChatActivity.class);
                kirim.putExtra("varNama", nama);
                kirim.putExtra("varChat", chat);
                kirim.putExtra("varJam", jam);
                kirim.putExtra("varNomor", nomor);
                kirim.putExtra("varStatus", status);
                kirim.putExtra("varTanggalStatus", tanggalStatus);
                kirim.putExtra("1", foto);

                holder.itemView.getContext().startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {

        return dataChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNama, tvChat, tvJam, tvNomor, tvStatus, tvTanggalStatus;
        private final ShapeableImageView iFoto;
        private final LinearLayout ly_chat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvChat = itemView.findViewById(R.id.tv_chat);
            tvJam = itemView.findViewById(R.id.tv_jam);
            iFoto = itemView.findViewById(R.id.img);
            ly_chat = itemView.findViewById(R.id.ly_chat);
            tvNomor = itemView.findViewById(R.id.nomor);
            tvStatus = itemView.findViewById(R.id.status);
            tvTanggalStatus = itemView.findViewById(R.id.tanggalstatus);
        }
    }
}
