package com.example.photo;

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
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private ImageView image1;
    private EditText text2;
    private Button button1;
    private String st,sw,sx,sz;
    private Uri imageUri; // declare global variable for image URI

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        image1 = findViewById(R.id.image2);
        text2 = findViewById(R.id.text);
        button1 = findViewById(R.id.submit1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageUri == null) {
                    Toast.makeText(SecondActivity.this, "Pick a photo first", Toast.LENGTH_SHORT).show();
                    return;
                }
                    Intent it = new Intent(SecondActivity.this, ThirdActivity.class);
                    st = text2.getText().toString();
                    sw = getIntent().getExtras().getString("image");
                    sx = getIntent().getExtras().getString("Value");
                    sz = getIntent().getExtras().getString("Value1");
                    it.putExtra("Value3", st);
                    it.putExtra("image2", imageUri.toString());
                    it.putExtra("image",sw);
                    it.putExtra("text1",sx);
                    it.putExtra("text2",sz);
            startActivity(it);
                    finish();

            }
        });


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == 0 && resultCode == RESULT_OK && data != null){
            imageUri = data.getData();
            image1.setImageURI(imageUri);
        }



    }

}
