package com.example.localdatapersistent;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABLE_NAME = "notes";

    public static final class NoteColumns implements BaseColumns {
        public static String JUDUL = "judul";
        public static String WAKTU = "waktu";
        public static String DESKRIPSI = "deskripsi";
    }
}
