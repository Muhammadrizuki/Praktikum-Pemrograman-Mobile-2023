package com.example.applicationfragment;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    private ImageView image1,profil;

    private TextView text1,text2;

    private EditText et;

    private BlankFragment blankFragment;
    private Uri imageUri;
    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        SharedViewModel viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        image1 = view.findViewById(R.id.image1);
        et = view.findViewById(R.id.edittext1);


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        Button uploadButton = view.findViewById(R.id.button);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment blankFragment = new BlankFragment();
                Bitmap bitmap = ((BitmapDrawable) image1.getDrawable()).getBitmap();
                String string = et.getText().toString();
                Parcable parcable = new Parcable(string,bitmap);
                viewModel.setData(parcable);
                Bundle bundle = new Bundle();
                bundle.putParcelable("et",parcable);
                blankFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container,blankFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                 }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            image1.setImageURI(imageUri);

        }
    }


}
