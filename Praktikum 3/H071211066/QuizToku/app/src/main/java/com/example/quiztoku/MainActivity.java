package com.example.quiztoku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText eNama;
    private TextView tScore, tNama;
    private Button btnApply, btnPlay;
    private Uri uri;

    private ImageView iImage;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNama = findViewById(R.id.eNama);
        tScore = findViewById(R.id.score);
        tNama = findViewById(R.id.nama);
        btnApply = findViewById(R.id.apply);
        btnPlay = findViewById(R.id.play);
        iImage = findViewById(R.id.image);
        uri = Uri.parse("");

    }

    public void apply(View view) {

        String nama = eNama.getText().toString();

        if (nama.isEmpty()) {
            eNama.setError("Input Your Name");
        } else {
            eNama.setVisibility(View.GONE);
            tNama.setVisibility(View.VISIBLE);
            tScore.setVisibility(View.VISIBLE);
            btnApply.setVisibility(View.GONE);
            btnPlay.setVisibility(View.VISIBLE);

            tNama.setText(nama);
        }
    }

    public void image(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==RESULT_OK) {
            uri = data.getData();
            iImage.setImageURI(uri);
        }
    }

    public void play(View view) {
        String nama = tNama.getText().toString();
        Intent play = new Intent(MainActivity.this, QuizActivity.class);
        play.putExtra(QuizActivity.EXTRA_PROFIL, uri.toString());
        play.putExtra(QuizActivity.EXTRA_NAMA, nama);
        startActivity(play);
    }
}