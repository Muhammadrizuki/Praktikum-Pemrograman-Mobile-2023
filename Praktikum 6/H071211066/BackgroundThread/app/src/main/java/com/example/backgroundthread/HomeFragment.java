package com.example.backgroundthread;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        TextView text = view.findViewById(R.id.text);

//        DataUpload.setList(new UploadModel("Bunga teratai menjadi salah satu tumbuhan air yang menarik. Tanaman ini berbentuk bundar atau oval. " +
//                "Bunga ini hidup di permukaan air yang tenang dan indah untuk dipandang. " +
//                "Sejak zaman Mesir kuno, teratai sudah ada. Kemudian dalam agama Hindu, teratai merupakan simbol dari kesucian.",
//                "https://i.pinimg.com/originals/ef/31/e1/ef31e17efcc360bb143930d1aa09635d.gif",
//                "https://th.bing.com/th/id/OIP.1VhtG8KGQQ9JIQCJn0efLgHaHe?pid=ImgDet&rs=1",
//                "Nama", "zakiah"));
//        DataUpload.setList(new UploadModel("Halo guys.....",
//                "https://sharingconten.com/wp-content/uploads/2020/01/Gambar-Kartun-Muslimah-Anak-Kecil.jpg",
//                "https://sharingconten.com/wp-content/uploads/2020/01/Gambar-Kartun-Muslimah-Anak-Kecil.jpg",
//                "Nama", "syifa"));
//        DataUpload.setList(new UploadModel("Dark....",
//                "https://th.bing.com/th/id/R.a4451589aea418221d7ba941a35e192d?rik=ATc3E61ubgPqYw&riu=http%3a%2f%2feskipaper.com%2fimages%2fdark-8.jpg&ehk=G6A9yXk6rMCOZ%2fX3DlezXOP%2bmfp8ghJ%2fSqCQZlMH4Gw%3d&risl=&pid=ImgRaw&r=0",
//                "https://i.pinimg.com/originals/ed/86/82/ed86822d476d2581b29a04f455a32ab2.jpg",
//                "Nama", "fadli"));
        ArrayList<UploadModel> uploads = DataUpload.getList();
        RecyclerView rvUploads = view.findViewById(R.id.rv_upload);
        rvUploads.setHasFixedSize(true);
        rvUploads.setLayoutManager(new LinearLayoutManager(getActivity()));
        UploadAdapter adapter = new UploadAdapter(getContext(), uploads);
        rvUploads.setAdapter(adapter);
        text.setVisibility(view.GONE);

//        if (bundle!=null){
//            ArrayList<UploadModel> upload = bundle.getParcelableArrayList("key_upload");
//            RecyclerView rvUploads = view.findViewById(R.id.rv_upload);
//            rvUploads.setHasFixedSize(true);
//            rvUploads.setLayoutManager(new LinearLayoutManager(getActivity()));
//            UploadAdapter adapter = new UploadAdapter(getContext(), upload);
//            rvUploads.setAdapter(adapter);
//            text.setVisibility(view.GONE);
//        } else {
//
////            text.setText("Please add a post first");
//        }
    }
}