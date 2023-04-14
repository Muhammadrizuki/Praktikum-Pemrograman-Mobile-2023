package com.example.intentassignment;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editNama, editUsern;
    private ImageView iImage;
    private Uri uri;
//    private final ActivityResultLauncher<Intent> launcherPickPhoto = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(), result -> {
//                String text = result.getResultCode() == RESULT_OK
//                        ? "Success picking a photo"
//                        : "Not picking a photo";
//                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
//            }
//    );

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNama = findViewById(R.id.nama);
        editUsern = findViewById(R.id.usern);
        iImage = findViewById(R.id.image);
        uri = Uri.parse("");
    }

    public void image(View view) {
//        Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
//        intentPicker.setType("image/*");
//        launcherPickPhoto.launch(Intent.createChooser(intentPicker, "Pick a photo"));
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
//        startActivityForResult(intentPicker, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==RESULT_OK) {
            uri = data.getData();
            iImage.setImageURI(uri);
        }
    }

    public void submit(View view) {
        String nama = editNama.getText().toString();
        String username = editUsern.getText().toString();
        String profile = uri.toString();

        if (profile == "") {
            Toast.makeText(MainActivity.this, "Please pick a photo profile first", Toast.LENGTH_SHORT).show();
        } else if (nama.isEmpty() && username.isEmpty()){
            editNama.setError("Field can't be empty");
            editUsern.setError("Field can't be empty");
        } else if (username.isEmpty()){
            editUsern.setError("Field can't be empty");
        } else if (nama.isEmpty()) {
            editNama.setError("Field can't be empty");
        } else {
            Intent upload = new Intent(MainActivity.this, UploadActivity.class);
            upload.putExtra(UploadActivity.EXTRA_NAME, nama);
            upload.putExtra(UploadActivity.EXTRA_USER, username);
            upload.putExtra(UploadActivity.EXTRA_PROFILE, profile);
            startActivity(upload);
        }
    }
}