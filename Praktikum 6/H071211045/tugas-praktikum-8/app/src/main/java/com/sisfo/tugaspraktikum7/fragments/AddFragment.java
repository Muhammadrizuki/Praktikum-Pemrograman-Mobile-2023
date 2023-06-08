package com.sisfo.tugaspraktikum7.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sisfo.tugaspraktikum7.MainActivity;
import com.sisfo.tugaspraktikum7.R;
import com.sisfo.tugaspraktikum7.databinding.FragmentAddBinding;
import com.sisfo.tugaspraktikum7.datasource.Account;
import com.sisfo.tugaspraktikum7.datasource.Storage;
import com.sisfo.tugaspraktikum7.model.Post;

public class AddFragment extends Fragment {

    private FragmentAddBinding binding;
    private Uri postUri;
    public AddFragment() {/* Constructor */}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentAddBinding.bind(view);

        binding.cvPostImageUpload.setOnClickListener(v -> {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            galleryLauncher.launch(Intent.createChooser(intent, "Choose a photo"));
        });

        binding.btnUpload.setOnClickListener(v -> {
            if (postUri == null) {
                Toast.makeText(getActivity(), "Please upload an image first!", Toast.LENGTH_SHORT).show();
                return;
            }

            Bundle bundle = new Bundle();
            Post post = new Post(Account.user.getUsername(), postUri.toString(), binding.etCaption.getText().toString());
            HomeFragment homeFragment = new HomeFragment();
            MainActivity parent = (MainActivity) getActivity();

//            bundle.putParcelable("POST", post);
//            homeFragment.setArguments(bundle);

//            Storage.addPost(post, Account.user.getUsername());

            Storage.users.get(Account.userID).addPost(post);
            Storage.posts.add(0, post);

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .addToBackStack(null)
                    .commit();

            parent.binding.tvTitle.setText("Inigaram");
        });
    }

    private final ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), photo -> {
                if (photo.getResultCode() == Activity.RESULT_OK) {
                    postUri = photo.getData().getData();
                    binding.ivPostImageView.setImageURI(postUri);
                }
            });
}