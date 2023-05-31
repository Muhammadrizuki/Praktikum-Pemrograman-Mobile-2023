package com.example.tugas4mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView2;

    LinearLayoutManager layoutManager;
    List<ModelClass2> chatList;

    List<ModelClass2> pesansetiapuser;

    private  ImageView imageView;
    private TextView nama,pesan,waktu;

    AdapterChats adapter2;

    ModelClass modelClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.profile);
        nama = findViewById(R.id.username);


        Data();

        modelClass = getIntent().getParcelableExtra("semua data");
        imageView.setImageResource(modelClass.getImageView1());
        nama.setText(modelClass.getTv1());



        ambilPesanUntukUser(modelClass.getTv1());


        RecyclerView();

    }

    private  void Data(){
        chatList = new ArrayList<>();
        chatList.add(new ModelClass2("tuna tuna ikura, tuna mayo ikura, tuna tuna tuna mayo, tuna mayo ikura, takana", "15:30","Toge Inumaki"));
        chatList.add(new ModelClass2("sushi ikura tuna", "10:39","Toge Inumaki"));
        chatList.add(new ModelClass2("ramen mayo ", "10:40","Toge Inumaki"));
        chatList.add(new ModelClass2("wasabi mAyo tuna", "10:42","Toge Inumaki"));
        chatList.add(new ModelClass2("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore", "24:55","Yuji Itadori"));
        chatList.add(new ModelClass2("vitae sapien pellentesque habitant morbi tristique. Preti ", "24:57","Yuji Itadori"));
        chatList.add(new ModelClass2("Malesuada pellentesque elit eget gravida cum sociis natoque penatibus et. ", "24:58","Yuji Itadori"));
        chatList.add(new ModelClass2("Vestibulum rhoncus est pellentesque elit ullamcorper.", "16:29", "Megumi Fushiguro"));
        chatList.add(new ModelClass2("Volutpat consequat mauris nunc congue nisi.", "16:28", "Megumi Fushiguro"));
        chatList.add(new ModelClass2("Vitae congue mauris rhoncus aenean vel elit scelerisque. Amet venenatis urna cursus eget nunc scelerisque. Facilisis volutpat est velit egestas. ", "16:30", "Megumi Fushiguro"));
        chatList.add(new ModelClass2("Ullamcorper a lacus vestibulum sed arcu non odio euismod lacinia. Pellentesque dignissim enim sit amet venenatis urna cursus eget nunc. ", "15:27", "Satoru Gojo"));
        chatList.add(new ModelClass2("Ullamcorper a lacus vestibulum susit amet venenatis urna cursus eget nunc. ", "15:28", "Satoru Gojo"));
        chatList.add(new ModelClass2(" Congue mauris rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar.", "15:29", "Satoru Gojo"));
        chatList.add(new ModelClass2(" Maecenas accumsan lacus vel facilisis.", "15:30", "Satoru Gojo"));
        chatList.add(new ModelClass2("Blandit libero volutpat sed cras ornare", "17:49", "Panda"));
        chatList.add(new ModelClass2("Dolor sit amet consectetur adipiscing.", "17:50", "Panda"));
        chatList.add(new ModelClass2("Arcu non sodales neque sodales ut etiam sit amet nisl.", "17:58", "Panda"));
        chatList.add(new ModelClass2("Fames ac turpis", "18:00", "Panda"));
        chatList.add(new ModelClass2("Velit dignissim sodales ut eu sem integer vitae justo eget. ", "03:59", "Kento Nanami"));
        chatList.add(new ModelClass2("Habitant morbi tristique senectus et. Nulla porttitor massa id neque aliquam ", "04:00", "Kento Nanami"));
        chatList.add(new ModelClass2("Felis eget velit aliquet sagittis id.", "12:01", "Nobara Kugisaki"));
        chatList.add(new ModelClass2("Interdum posuere lorem ipsum dolor sit amet consectetur adipiscing.", "12:03", "Nobara Kugisaki"));
        chatList.add(new ModelClass2("Viverra ipsum ", "12:04", "Nobara Kugisaki"));
        chatList.add(new ModelClass2("Dolor magna eget est lorem ipsum dolor.", "19:18", "Sukuna"));
        chatList.add(new ModelClass2("Turpis in eu mi bibendum neque egestas congue. Pulvinar pellentesque habitant morbi tristique senectus.", "19:19", "Sukuna"));
        chatList.add(new ModelClass2("Sed risus ultricies", "19:20", "Sukuna"));
        chatList.add(new ModelClass2("Sed libero enim sed faucibus turpis in", "19:30", "Sukuna"));
        chatList.add(new ModelClass2("Purus in mollis nunc sed id semper risus.", "19:31", "Sukuna"));
        chatList.add(new ModelClass2("Varius sit amet", "19:30", "Sukuna"));
        chatList.add(new ModelClass2("Mauris augue neque gravida in. Quisque non tellus orci ac auctor augue mauris. Augue lacus viverra vitae congue eu.", "22:24", "Toji Fushiguro"));
        chatList.add(new ModelClass2("Varius sit amet mattis vulputate enim nulla aliquet. ", "19:33", "Mahito"));
        chatList.add(new ModelClass2(" Vitae turpis massa sed ", "24:24", "Mahito"));


    }
    public void ambilPesanUntukUser(String nama){
        pesansetiapuser = new ArrayList<>();
        for (ModelClass2 pesan : chatList){
            if(pesan.getNama().equals(nama)){
                pesansetiapuser.add(pesan);
            }
        }
    }
    private  void RecyclerView(){
        recyclerView2 = findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView2.setLayoutManager(layoutManager);
        adapter2 = new AdapterChats(pesansetiapuser);
        recyclerView2.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
    }
    public void viewImage(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        intent.putExtra("semua data",modelClass);
        startActivity(intent);
    }

    public void backToContact(View view) {
       finish();
    }
}