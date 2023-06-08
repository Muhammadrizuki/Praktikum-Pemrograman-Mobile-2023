package com.sisfo.tugaspraktikum6.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sisfo.tugaspraktikum6.R;
import com.sisfo.tugaspraktikum6.model.Bubble;

import java.util.List;

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ViewHolder> {
    private final List<Bubble> bubbles;

    public ConversationAdapter(List<Bubble> bubbles) {
        this.bubbles = bubbles;
    }

    @Override
        public int getItemViewType(int position) {
        Bubble bubble = bubbles.get(position);
        return (bubble.getType().equals("left") ? 0 : 1);
    }

    @NonNull
    @Override
    public ConversationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View leftBubble = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_bubble_left, parent, false);
                return new ViewHolder(leftBubble);
            case 1:
                View rightBubble = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_bubble_right, parent, false);
                return new ViewHolder(rightBubble);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationAdapter.ViewHolder holder, int position) {
        Bubble bubble = bubbles.get(position);
        holder.bind(bubble);
    }

    @Override
    public int getItemCount() {
        return bubbles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvContent, tvTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_chat_content);
            tvTime = itemView.findViewById(R.id.tv_chat_time);
        }

        public void bind(Bubble bubble) {
            tvContent.setText(bubble.getText());
            tvTime.setText(bubble.getTime());
        }
    }
}