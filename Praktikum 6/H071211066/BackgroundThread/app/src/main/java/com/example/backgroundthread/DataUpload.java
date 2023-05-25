package com.example.backgroundthread;

import java.util.ArrayList;
import java.util.Arrays;

public class DataUpload {
    public static ArrayList<UploadModel> uploads = new ArrayList<>(
            Arrays.asList(
                    new UploadModel("Bunga teratai menjadi salah satu tumbuhan air yang menarik. Tanaman ini berbentuk bundar atau oval. " +
                "Bunga ini hidup di permukaan air yang tenang dan indah untuk dipandang. " +
                "Sejak zaman Mesir kuno, teratai sudah ada. Kemudian dalam agama Hindu, teratai merupakan simbol dari kesucian.",
                "https://i.pinimg.com/originals/ef/31/e1/ef31e17efcc360bb143930d1aa09635d.gif",
                "https://th.bing.com/th/id/OIP.1VhtG8KGQQ9JIQCJn0efLgHaHe?pid=ImgDet&rs=1",
                "Zakiah Fitri", "zakiah"),
                new UploadModel("Dark....",
                "https://th.bing.com/th/id/R.a4451589aea418221d7ba941a35e192d?rik=ATc3E61ubgPqYw&riu=http%3a%2f%2feskipaper.com%2fimages%2fdark-8.jpg&ehk=G6A9yXk6rMCOZ%2fX3DlezXOP%2bmfp8ghJ%2fSqCQZlMH4Gw%3d&risl=&pid=ImgRaw&r=0",
                "https://i.pinimg.com/originals/ed/86/82/ed86822d476d2581b29a04f455a32ab2.jpg",
                "Dzul Fadli", "fadli"),
                    new UploadModel("Halo guys.....",
                            "https://sharingconten.com/wp-content/uploads/2020/01/Gambar-Kartun-Muslimah-Anak-Kecil.jpg",
                            "https://sharingconten.com/wp-content/uploads/2020/01/Gambar-Kartun-Muslimah-Anak-Kecil.jpg",
                            "Syifa Ur Rahmah", "syifa")));


    public static void setList(UploadModel uploadModel) {
        uploads.add(uploadModel);
    }
    public static ArrayList<UploadModel> getList() {
        return uploads;
    }
}
