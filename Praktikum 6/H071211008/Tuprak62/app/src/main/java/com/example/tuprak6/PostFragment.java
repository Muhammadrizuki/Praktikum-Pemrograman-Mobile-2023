package com.example.tuprak6;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class PostFragment extends Fragment {
    private ImageView iv_foto;
    private EditText et_caps;
    private Button btn_upload;
    User user;
    String urii;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    private ActivityResultLauncher<Intent> imageCaptureLauncher=registerForActivityResult(new
                    ActivityResultContracts.StartActivityForResult(),
            result -> {
                // untuk menghandle data yang dikmbalikan galeri
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Uri uri = result.getData().getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), uri);
                        urii = uri.toString();
                        iv_foto.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
    );

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        iv_foto = view.findViewById(R.id.iv_foto);
        et_caps = view.findViewById(R.id.et_caps);
        btn_upload = view.findViewById(R.id.btn_upload);

        user = new User();

        iv_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                imageCaptureLauncher.launch(Intent.createChooser(intent, "Pilih Gambar"));
            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setCaption(et_caps.getText().toString());
                user.setPostingan(urii);

                if (isImageSelect()) {
                    Toast.makeText(getActivity(), "Add photo first", Toast.LENGTH_SHORT).show();
                } else {
                    HomeFragment homeFragment = new HomeFragment();
                    DataSource.dataa.add(user);

                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, homeFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.replaceFragment(new HomeFragment());
                    Toast.makeText(getActivity(), "Post Success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isImageSelect() {
        return user.getPostingan() == null;
    }
}