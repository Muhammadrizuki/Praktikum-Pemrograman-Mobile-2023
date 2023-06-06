package com.example.applicationfragment;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Parcable> getArrayList() {
        return arrayList;
    }

    public static void setArrayList(Parcable parcable) {
        arrayList.add(parcable);
    }

    static ArrayList<Parcable> arrayList = new ArrayList<>();


}
