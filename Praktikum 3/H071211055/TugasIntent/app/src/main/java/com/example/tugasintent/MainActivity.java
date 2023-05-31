package com.example.tugasintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    private EditText eFullName, eUsername;


    ShapeableImageView image;

    private Uri uri;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eFullName = findViewById(R.id.fullname);
        eUsername = findViewById(R.id.username);
        image = findViewById(R.id.image);

        uri = Uri.parse("");
    }
    public void moveToUpload(View view) {
        String fullname = eFullName.getText().toString();
        String username = eUsername.getText().toString();
        String profil = uri.toString();

        if (uri.toString() == "") {
            Toast.makeText(MainActivity.this, "Please pick a picture ", Toast.LENGTH_SHORT).show();
        } else if(fullname.isEmpty() && username.isEmpty()){
            eFullName.setError("Field can't be Empty");
            eUsername.setError("Field can't be Empty");
        } else if (fullname.isEmpty()){
            eFullName.setError("Field can't be Empty");
        } else if (username.isEmpty()){
            eUsername.setError("Field can't be Empty");
        } else {
            Intent post = new Intent(MainActivity.this, UploadActivity.class);
            post.putExtra(UploadActivity.EXTRA_FULLNAME, fullname);
            post.putExtra(UploadActivity.EXTRA_USERNAME, username);
            post.putExtra(UploadActivity.EXTRA_PROFILE, profil);
            startActivity(post);
        }
    }

    public void image(View view) {
        Intent image = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(image, 1); //memulai memilih gambar
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data); //mengecek apakah hasil startactivityforrslt berhasilmi atau tidak
        if (requestCode==1&&resultCode==RESULT_OK) {
            uri = data.getData(); //uri itu path gambar
            image.setImageURI(Uri.parse(uri.toString())); //menampilkan data dari foto yang dipilih
        }
    }
}


