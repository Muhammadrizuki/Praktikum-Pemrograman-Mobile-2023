package com.sisfo.tugaspraktikum6.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.sisfo.tugaspraktikum6.R;
import com.sisfo.tugaspraktikum6.adapter.ChatAdapter;
import com.sisfo.tugaspraktikum6.model.ContactBook;
import com.sisfo.tugaspraktikum6.model.Conversation;
import com.sisfo.tugaspraktikum6.model.ConversationList;
import com.sisfo.tugaspraktikum6.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        String contactJson = Utils.getJsonFromAssets(this, "contacts.json");
        ContactBook contacts = gson.fromJson(contactJson, ContactBook.class);

        String conversationJson = Utils.getJsonFromAssets(this, "conversations.json");
        ConversationList conversations = gson.fromJson(conversationJson, ConversationList.class);

        RecyclerView recyclerView = findViewById(R.id.rv_chats);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChatAdapter(contacts.list(), conversations.list()));

    }
}