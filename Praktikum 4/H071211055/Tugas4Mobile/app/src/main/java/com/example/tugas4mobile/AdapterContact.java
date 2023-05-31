package com.example.tugas4mobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHolder> {

    private List<ModelClass> userList;



    private Context context;

    public AdapterContact(List<ModelClass> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterContact.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.ViewHolder holder, int position) {
        int resource = userList.get(position).getImageView1();
        String nama = userList.get(position).getTv1();
        String waktu = userList.get(position).getTv2();
        String pesan = userList.get(position).getTv3();
        String garis = userList.get(position).getDivider();
        String nomor = userList.get(position).getNomor();
        String status = userList.get(position).getStatus();
        String tanggal = userList.get(position).getTanggal();


        ModelClass modelClass = new ModelClass(resource,nama,waktu,pesan,garis,nomor,status,tanggal);
        holder.setData(resource,nama,waktu,pesan,garis);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context,MainActivity2.class);
            intent.putExtra("semua data",modelClass);
            context.startActivity(intent);
        });

        holder.imageView.setOnClickListener(view ->{
            Intent intent = new Intent(context,MainActivity4.class);
            intent.putExtra("foto",modelClass);
            context.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tv1,tv2,tv3,divider;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView1);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            divider = itemView.findViewById(R.id.divider);

        }

        public void setData(int resource, String nama, String waktu, String pesan, String garis) {

            imageView.setImageResource(resource);
            tv1.setText(nama);
            tv2.setText(waktu);
            tv3.setText(pesan);
            divider.setText(garis);
        }
    }
}
