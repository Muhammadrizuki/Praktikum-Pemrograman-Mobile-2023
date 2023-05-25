package com.example.myapplication;

import java.util.ArrayList;

public class DataUpload {
    public static ArrayList<UploadModel> uploads = new ArrayList<>();
    public static void setList(UploadModel upload) {
        uploads.add(upload);
    }
    public static ArrayList<UploadModel> getList() {
        return uploads;
    }
}
