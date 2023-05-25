package com.example.myapplication;

import static android.app.Activity.RESULT_OK;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Debug;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UploadFragment extends Fragment {
    private String uri;
    private ImageView iImage;
//    private ArrayList<UploadModel> uploads = new ArrayList<>();
    ActivityResultLauncher<Intent> addPost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iImage = view.findViewById(R.id.post_photo);

        ImageView photo = view.findViewById(R.id.post_photo);
        addPost = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                Uri uri1 = result.getData().getData();
                if (uri1!=null) {
                    uri = uri1.toString();
                    iImage.setImageURI(uri1);
                }
            }
                });
        photo.setOnClickListener(photo_ ->{
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            addPost.launch(intent);
                });
        Button upload = view.findViewById(R.id.upload);
        upload.setOnClickListener(upload_ -> {

            EditText capt = view.findViewById(R.id.capt);
            String caption = capt.getText().toString();
            if (uri == null) {
                Toast.makeText(getActivity(), "Please pick a post photo first", Toast.LENGTH_SHORT).show();
            } else if (caption.isEmpty()) {
                capt.setError("Field can't be empty");
            } else {
                DataUpload.setList(new UploadModel(caption, Uri.parse(uri)));

                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("key_upload", DataUpload.getList());

                Intent intent = getActivity().getIntent();
                intent.putExtras(bundle);
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);

                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, homeFragment)
                        .commit();
                Toast.makeText(getActivity(), "Post Success", Toast.LENGTH_SHORT).show();

            }
            capt.getText().clear();
        });
    }
}