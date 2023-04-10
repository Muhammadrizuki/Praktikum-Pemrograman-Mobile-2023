package com.example.photo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private CircleImageView image;
    private String st,st1;
    private Button submit;

    private TextInputEditText text1,text2;

    private Uri imageUri;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submit);
        image = findViewById(R.id.profileImageView);
        text1 = findViewById(R.id.InputText1);
        text2 = findViewById(R.id.InputText2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty()) {
                    text1.setError("Required");
                } else if (text2.getText().toString().isEmpty()) {
                    text2.setError("This field is required !");
                } else if(imageUri == null){
                    Toast.makeText(MainActivity.this, "Pick a picture first", Toast.LENGTH_SHORT).show();
                } else {
                    text1.setError(null);
                    text2.setError(null);
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    st = text1.getText().toString();
                    st1 = text2.getText().toString();
                    i.putExtra("Value", st);
                    i.putExtra("Value1", st1);
                    i.putExtra("image",imageUri.toString());
                    startActivity(i);
                    finish();
                }
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,0);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == 0 && resultCode == RESULT_OK && data != null){
            imageUri = data.getData();
            image.setImageURI(imageUri);
        }

    }


}