package com.sisfo.tugaspraktikum7.utilities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

import com.google.gson.annotations.SerializedName;
import com.sisfo.tugaspraktikum7.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    public static Drawable getDrawable(Context context, int drawable) {
        return ResourcesCompat.getDrawable(context.getResources(), drawable, null);
    }

    public static class UserList {
        @SerializedName("users")
        private final List<User> users = new ArrayList<>();

        public List<User> list() {
            return users;
        }
    }
}
