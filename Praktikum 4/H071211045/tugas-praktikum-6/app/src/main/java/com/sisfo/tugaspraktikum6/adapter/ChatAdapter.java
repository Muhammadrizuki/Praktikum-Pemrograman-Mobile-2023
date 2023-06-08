package com.sisfo.tugaspraktikum6.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
<<<<<<< Updated upstream
=======
import androidx.cardview.widget.CardView;
>>>>>>> Stashed changes
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sisfo.tugaspraktikum6.R;
import com.sisfo.tugaspraktikum6.activity.ConversationActivity;
<<<<<<< Updated upstream
=======
import com.sisfo.tugaspraktikum6.activity.ImageActivity;
import com.sisfo.tugaspraktikum6.activity.ProfileActivity;
>>>>>>> Stashed changes
import com.sisfo.tugaspraktikum6.model.Bubble;
import com.sisfo.tugaspraktikum6.model.Contact;
import com.sisfo.tugaspraktikum6.model.Conversation;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{

    private final List<Contact> contacts;
    private final List<Conversation> conversations;

    public ChatAdapter(List<Contact> contacts, List<Conversation> conversations) {
        this.contacts = contacts;
        this.conversations = conversations;
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        Conversation conversation = conversations.get(position);
        holder.bind(contact, conversation);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView profilePicture;
        private RelativeLayout chatCard;
<<<<<<< Updated upstream
=======
        private CardView imageCard;
>>>>>>> Stashed changes
        private final TextView tvName, tvContent, tvTime;
        public ViewHolder(@NonNull View item) {
            super(item);

            profilePicture = item.findViewById(R.id.rv_item_image);
            tvName = item.findViewById(R.id.rv_item_name);
            tvContent = item.findViewById(R.id.rv_item_content);
            tvTime = item.findViewById(R.id.rv_item_time);
            chatCard = item.findViewById(R.id.chat_card);
<<<<<<< Updated upstream

            chatCard.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), ConversationActivity.class);
                intent.putExtra("name", tvName.getText().toString());
                v.getContext().startActivity(intent);

=======
            imageCard = item.findViewById(R.id.cv_image);

            chatCard.setOnClickListener(v -> {
                Intent toConversation = new Intent(v.getContext(), ConversationActivity.class);
                toConversation.putExtra("contact", contacts.get(getAdapterPosition()));
                toConversation.putExtra("conversation", conversations.get(getAdapterPosition()));
                v.getContext().startActivity(toConversation);
            });

            imageCard.setOnClickListener(v -> {
                Intent toProfile = new Intent(v.getContext(), ImageActivity.class);
                toProfile.putExtra("imageContent", contacts.get(getAdapterPosition()).getProfilePicture());
                v.getContext().startActivity(toProfile);
>>>>>>> Stashed changes
            });
        }

        public void bind(Contact contact, Conversation conversation) {

            if (!contact.getProfilePicture().isEmpty()) {
                Glide.with(itemView.getContext())
                        .load(contact.getProfilePicture())
                        .into(profilePicture);
            }

            Bubble bubble = conversation.getBubbles()
                    .get(conversation.getBubbles().size() - 1);

            tvName.setText(contact.getName());
            tvContent.setText(bubble.getText());

            /* Ingredients */
            if (!(bubble.getTime().equals("04.31") || bubble.getTime().equals("09.13") || bubble.getTime().equals("13.12")))
                tvTime.setText("Yesterday");
            else
                tvTime.setText(bubble.getTime());
        }
    }
}
