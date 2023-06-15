package com.example.tuprak32;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

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
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private ImageView iv_foto, tes;
    private EditText et_caps;
    private Button btn_upload;
    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_GALERI = 2;
    private Uri imageUri;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        iv_foto = findViewById(R.id.iv_foto);
        et_caps = findViewById(R.id.et_caps);
        btn_upload = findViewById(R.id.btn_upload);
        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String user = intent.getStringExtra("user");

        Bundle fotoprofil = getIntent().getExtras();
        if (fotoprofil!= null){
            bitmap =fotoprofil.getParcelable("profil");
        }

        iv_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOption();
            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String caps = et_caps.getText().toString();
                Drawable drawable = iv_foto.getDrawable();
                Bundle bundle = new Bundle();
                bundle.putParcelable("foto", ((BitmapDrawable)drawable).getBitmap());
                if (isImageSelec()){
                    Toast.makeText(getApplicationContext(),"add photo first!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("nama", nama);
                    intent.putExtra("user", user);
                    intent.putExtra("caps", caps);
                    intent.putExtras(bundle);
                    intent.putExtra("profil", bitmap);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isImageSelec() {
        return imageUri == null;
    }

    private void showOption() {
        final CharSequence[] options = {"Camera", "Galeri"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
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

        imageUri = FileProvider.getUriForFile(MainActivity2.this,
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
                    iv_foto.setImageURI(imageUri);
                    break;
                case REQUEST_GALERI:
                    imageUri = data.getData();
                    iv_foto.setImageURI(imageUri);
                    break;
            }
        }
    }
}