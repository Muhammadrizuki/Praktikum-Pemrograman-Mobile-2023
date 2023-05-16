package com.sisfo.tugaspraktikum6.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

import com.sisfo.tugaspraktikum6.R;

public class ConversationActivity extends AppCompatActivity {

    CardView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        backButton = findViewById(R.id.conversation_back_button_container);
//        backButton.setOnClickListener(v -> {
//            finish();
//        });
    }
}