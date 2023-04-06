package com.example.tuprak32;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ImageView iv_profil;
    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_GALERI = 2;
    private Uri imageUri;
    private EditText et_name, et_user;
    private Button btn_submit;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_profil = findViewById(R.id.iv_profil);
        et_name =  findViewById(R.id.et_name);
        et_user = findViewById(R.id.et_user);
        btn_submit = findViewById(R.id.btn_submit);

        iv_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOption();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = et_name.getText().toString();
                String user = et_user.getText().toString();

                Drawable drawable = iv_profil.getDrawable();
                Bundle fotoprofil = new Bundle();
                fotoprofil.putParcelable("profil", ((BitmapDrawable)drawable).getBitmap());

                Boolean isEmpty = false;

                if (isImageSelected()){
                    if (nama.isEmpty()){
                        et_name.setError("Can't be empty");
                        Toast.makeText(getApplicationContext(), "Enter your name!", Toast.LENGTH_SHORT).show();
                        isEmpty = true;
                    }
                    if (user.isEmpty()){
                        et_user.setError("Can't be empty");
                        Toast.makeText(getApplicationContext(), "Enter your username!", Toast.LENGTH_SHORT).show();
                        isEmpty = true;
                    }
                    if (!isEmpty){
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("nama", nama);
                        intent.putExtra("user", user);
                        intent.putExtras(fotoprofil);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Pick your profile first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isImageSelected() {
        return imageUri != null;
    }

    private void showOption() {
        final CharSequence[] options = {"Camera", "Galeri"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Pilih foto dari");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (options[i].equals("Camera")){
                    openCamera();
                } else if (options[i].equals("Galeri")) {
                    openGaleri();
                }
            }
        });
        builder.show();
    }

    private void openGaleri() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_GALERI);
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photoFile = createImageFile();

        imageUri = FileProvider.getUriForFile(MainActivity.this,
                BuildConfig.APPLICATION_ID + ".provider", photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private File createImageFile() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName, ".JPEG", storageDir
            );
        }catch (IOException e){
            e.printStackTrace();
        }
        return  image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAMERA:
                    iv_profil.setImageURI(imageUri);
                    break;
                case REQUEST_GALERI:
                    imageUri = data.getData();
                    iv_profil.setImageURI(imageUri);
                    break;
            }
        }
    }
}