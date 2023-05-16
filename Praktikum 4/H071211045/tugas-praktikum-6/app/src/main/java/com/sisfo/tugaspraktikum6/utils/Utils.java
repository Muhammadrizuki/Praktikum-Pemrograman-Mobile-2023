package com.sisfo.tugaspraktikum6.utils;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;

        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");

        } catch (IOException e) {
            Toast.makeText(context, "Failed to load your contacts!", Toast.LENGTH_SHORT).show();
            return null;
        }

        return jsonString;
    }
}
