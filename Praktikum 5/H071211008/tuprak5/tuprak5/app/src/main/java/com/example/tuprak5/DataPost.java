package com.example.tuprak5;

import java.util.ArrayList;

public class DataPost {
    static ArrayList<User> dato = new ArrayList<>();

    public static  ArrayList<User> getData() {
        return dato;
    }

    public static void setData(User data) {
        dato.add(data);
    }
}
