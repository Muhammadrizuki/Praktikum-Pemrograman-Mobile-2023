package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    LinearLayoutManager lm;
    List<ModelClass>userList;
    Adapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initdata();
        initRecyclerview();
    }

    private void initdata() {
        userList = new ArrayList<>();
        userList.add(new ModelClass(R.drawable.gambar2,"Jacob", "7:45 pm","Where is my bag?","Udah makan","081355072297"));
        userList.add(new ModelClass(R.drawable.gambar3,"Math", "12:10 pm","Yeah bro","push limit","0896734561234"));
        userList.add(new ModelClass(R.drawable.gambar4,"James", "5:42 pm","Did she text you?","Dedede","081322121234"));
        userList.add(new ModelClass(R.drawable.gambar5,"Yerry", "9:45 am","The game start tomorrow","iyu kamseipau","08889996655"));
        userList.add(new ModelClass(R.drawable.gambar6,"Edo", "7:00 pm","Yes he is the suspect","i love r", "989898989"));
        userList.add(new ModelClass(R.drawable.gambar7,"Tery", "6:45 pm","Good job bro","ihuhu","90908989898"));
        userList.add(new ModelClass(R.drawable.gambar8,"Roman", "3:28 pm","You're the best","ihuhuhuh","8388383838"));
        userList.add(new ModelClass(R.drawable.gambar9,"Ziggler", "2:45 pm","Great","09090909090","889898989898"));
        userList.add(new ModelClass(R.drawable.gambar10,"Gerry", "1:13 am","So good!","iiiiii","83983983983"));
    }

    private void initRecyclerview() {
        rv = findViewById(R.id.recycler_view);
        lm = new LinearLayoutManager(this);
        lm.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(lm);
        ad = new Adapter(userList);
        rv.setAdapter(ad);
        ad.notifyDataSetChanged();
        ad.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                intent.putExtra("image",userList.get(position).getImageview1());
                intent.putExtra("textview",userList.get(position).getTextview());
                intent.putExtra("textview2",userList.get(position).getTextview3());
                intent.putExtra("textview3",userList.get(position).getTextview4());
                startActivity(intent);
            }
        });

    }
}