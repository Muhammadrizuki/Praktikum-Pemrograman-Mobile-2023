package com.example.whatsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter (List<ModelClass>userList){this.userList= userList;}
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int resource = userList.get(position).getImageview1();
        String name = userList.get(position).getTextview();
        String name1 = userList.get(position).getTextview1();
        String name2 = userList.get(position).getTextview2();
        String name3 = userList.get(position).getTextview3();
        String name4 = userList.get(position).getTextview4();

        holder.setData(resource,name,name1,name2,name3,name4);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView txt1,txt2,txt3,txt5,txt4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageview1);
            txt1 = itemView.findViewById(R.id.textview);
            txt2 = itemView.findViewById(R.id.textview1);
            txt3 = itemView.findViewById(R.id.textview2);
            txt4 = itemView.findViewById(R.id.text_no);
            txt5 = itemView.findViewById(R.id.text_status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }

        public void setData(int resource, String name, String name1, String name2,String name3, String name4) {
            img.setImageResource(resource);
            txt1.setText(name);
            txt2.setText(name1);
            txt3.setText(name2);
            txt4.setText(name4);
            txt5.setText(name3);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
