package com.example.tuprak6;

import static java.security.AccessController.getContext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {
    public static ArrayList<User> dataa = new ArrayList<>(
        Arrays.asList(new User("Harry Poter", "harry", "inicaption", "https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg")
        ));

    public static  ArrayList<User> getData() {
        return dataa;
    }
    public static ArrayList<User> setData() {
        return dataa;
    }
}
