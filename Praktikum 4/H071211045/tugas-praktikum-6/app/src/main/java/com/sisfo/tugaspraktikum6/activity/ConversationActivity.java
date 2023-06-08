package com.sisfo.tugaspraktikum6.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
<<<<<<< Updated upstream

import android.os.Bundle;

import com.sisfo.tugaspraktikum6.R;
=======
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sisfo.tugaspraktikum6.R;
import com.sisfo.tugaspraktikum6.adapter.ConversationAdapter;
import com.sisfo.tugaspraktikum6.model.Contact;
import com.sisfo.tugaspraktikum6.model.Conversation;
>>>>>>> Stashed changes

public class ConversationActivity extends AppCompatActivity {

    CardView backButton;
<<<<<<< Updated upstream
=======
    ImageView profilePicture;
    TextView profileName;
    RecyclerView chatBubbles;
    LinearLayout profileContainer;

>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

<<<<<<< Updated upstream
        backButton = findViewById(R.id.conversation_back_button_container);
//        backButton.setOnClickListener(v -> {
//            finish();
//        });
=======
        profilePicture = findViewById(R.id.conversation_profile_picture);
        profileName = findViewById(R.id.conversation_profile_name);
        chatBubbles = findViewById(R.id.conversation_recycler_view);
        backButton = findViewById(R.id.conversation_back_button_container);
        profileContainer = findViewById(R.id.conversation_top_bar);

        backButton.setOnClickListener(v -> finish());

        Contact contact = getIntent().getParcelableExtra("contact");
        Conversation conversation = getIntent().getParcelableExtra("conversation");

        String name = contact.getName();
        String number = contact.getNumber();
        String picture = contact.getProfilePicture();

        profileName.setText((!name.isEmpty()) ? name : number);

        profileContainer.setOnClickListener(v -> {
            Intent toProfile = new Intent(this, ProfileActivity.class)
                    .putExtra("contact", contact);;
            startActivity(toProfile);
        });

        if (!picture.isEmpty()) {
            Glide.with(this).load(picture).into(profilePicture);
        }

        chatBubbles.setNestedScrollingEnabled(false);
        chatBubbles.setLayoutManager(new LinearLayoutManager(this));
        chatBubbles.setAdapter(new ConversationAdapter(conversation.getBubbles()));
>>>>>>> Stashed changes
    }
}