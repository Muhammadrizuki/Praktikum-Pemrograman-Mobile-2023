package com.example.intentassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_USER = "extra_user";
    public static final String EXTRA_PROFILE = "extra_profile";

    private EditText editCapt;

    private ImageView iImage;

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        editCapt = findViewById(R.id.capt);
        iImage = findViewById(R.id.image);

        uri = Uri.parse("");
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

    public void upload(View view) {

        String cekPost = uri.toString();

        if (cekPost == "") {
            Toast.makeText(UploadActivity.this, "Please pick a post photo first", Toast.LENGTH_SHORT).show();
        } else {
            String capt = editCapt.getText().toString();
            String nama = getIntent().getStringExtra(EXTRA_NAME);
            String username = getIntent().getStringExtra(EXTRA_USER);
            String profile = getIntent().getStringExtra(EXTRA_PROFILE);

            Intent hasil = new Intent(UploadActivity.this, HasilActivity.class);
            hasil.putExtra(HasilActivity.EXTRA_NAME, nama);
            hasil.putExtra(HasilActivity.EXTRA_USER, username);
            hasil.putExtra(HasilActivity.EXTRA_CAPTION, capt);
            hasil.putExtra(HasilActivity.EXTRA_PROFILE, profile);
            hasil.putExtra(HasilActivity.EXTRA_POST, uri.toString());

            startActivity(hasil);
        }
    }
}