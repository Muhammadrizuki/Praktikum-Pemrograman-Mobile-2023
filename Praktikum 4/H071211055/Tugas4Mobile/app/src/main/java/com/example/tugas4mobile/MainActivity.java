package com.example.tugas4mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    AdapterContact adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Data();
        RecyclerView();


    }


    private void  Data(){
        userList = new ArrayList<>();
        userList.add(new ModelClass(R.drawable.toge, "Toge Inumaki","10:42", "tuna tuna ikura, tuna mayo ikura, tuna tuna tuna mayo, tuna mayo ikura, takana", "____________________________________","+8142627942","Ikura","20 februari 2019"));
        userList.add(new ModelClass(R.drawable.yuji, "Yuji Itadori", "24:58 ", "Malesuada pellentesque elit eget gravida cum sociis natoque penatibus et.", "____________________________________","+8145627942","sukuna","19 februari 2021"));
        userList.add(new ModelClass(R.drawable.megumi, "Megumi Fushiguro", "16:30 ", "Vitae congue mauris rhoncus aenean vel elit scelerisque. Amet venenatis urna cursus eget nunc scelerisque. Facilisis volutpat est velit egestas. ", "____________________________________","+8142627681","yabaii","6 februari 2018"));
        userList.add(new ModelClass(R.drawable.gojo, "Satoru Gojo", "15:30 ", "Maecenas accumsan lacus vel facilisis.", "____________________________________","+8142612142","kirai","14 februari 2019"));
        userList.add(new ModelClass(R.drawable.panda, "Panda", "18:00 ", "Fames ac turpis", "____________________________________","08426277382","nani?","17 februari 2015"));
        userList.add(new ModelClass(R.drawable.kento, "Kento Nanami", "04:00 ", "Habitant morbi tristique senectus et. Nulla porttitor massa id neque aliquam", "____________________________________","+8142644442","sokka-sokka","21 februari 2020"));
        userList.add(new ModelClass(R.drawable.nobara, "Nobara Kugisaki", "12:05", "Viverra ipsum", "____________________________________","+8142541942","gomenne","23 februari 2017"));
        userList.add(new ModelClass(R.drawable.sukuna, "Sukuna", "19:30 ", "Varius sit amet ", "____________________________________","+8142107942","arigatou","26 februari 2010"));
        userList.add(new ModelClass(R.drawable.toji, "Toji Fushiguro", "22:24 ", "Mauris augue neque gravida in. Quisque non tellus orci ac auctor augue mauris. Augue lacus viverra vitae congue eu.", "____________________________________","+8101127942","tadaima","11 februari 2022"));
        userList.add(new ModelClass(R.drawable.mahito, "Mahito", "24:24 ", " Vitae turpis massa sed ", "____________________________________","+8142627200","mosi-mosi","28 februari 2000"));
    }



    private void RecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterContact(userList,MainActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}