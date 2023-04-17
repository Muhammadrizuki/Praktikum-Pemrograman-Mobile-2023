package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ChatAdapter mChatAdapter;
    private List<Chat> mListChat;

    private TextView tv;

    private ImageView im;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tv = findViewById(R.id.tv_chat);
        im = findViewById(R.id.image_chat);

        int image = getIntent().getIntExtra("image",0);
        String name = getIntent().getStringExtra("textview");
        String name1 = getIntent().getStringExtra("textview2");

        String name2 = getIntent().getStringExtra("textview3");


        im.setImageResource(image);
        tv.setText(name)  ;

        mRecyclerView = findViewById(R.id.activity_chat);
        mListChat = new ArrayList<>();
        mListChat.add(new Chat("How are you?"));
        mListChat.add(new Chat("I'm fime?"));
        mListChat.add(new Chat("And you?"));
        mChatAdapter = new ChatAdapter(this, mListChat);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mChatAdapter);

        Button sendbutton = findViewById(R.id.button_chat_send);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = findViewById(R.id.edit_text_chat_input);
                String message = input.getText().toString();
                mListChat.add(new Chat(message));
                mChatAdapter.notifyDataSetChanged();
                input.setText("");
            }
        });

        LinearLayout ll = findViewById(R.id.layout);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChatActivity.this,StatusActivity.class);
                i.putExtra("image",image);
                i.putExtra("name",name);
                i.putExtra("no",name1);
                i.putExtra("status",name2);
                startActivity(i);
            }
        });

    }

}