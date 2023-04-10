package com.example.photo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ThirdActivity extends AppCompatActivity {

    private TextView text1,text2,text3;
    String st1,st2,st3;

    private CircleImageView image;

    private ImageView image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        image = findViewById(R.id.profileImageView);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        image3 = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        Bundle bundle1 = getIntent().getExtras();

        st1 = getIntent().getExtras().getString("text1");
        st2 = getIntent().getExtras().getString("text2");
        st3 = getIntent().getExtras().getString("Value3");

        text1.setText(st1);
        text2.setText(st2);
        text3.setText(st3);

        if (bundle != null) {
            String imageUriString = bundle.getString("image");
           Uri imageUri = Uri.parse(imageUriString);
            image.setImageURI(imageUri);

        }
         if (bundle1 != null) {
            String imageUriString1 = bundle1.getString("image2");
            Uri imageUri1 = Uri.parse(imageUriString1);
            image3.setImageURI(imageUri1);


        }
    }
}