package com.example.tugasmobile8last;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABLE_NAME = "note";

    public static final class NotesColumns implements BaseColumns {
        public static String TITLE = "title";
        public static String  DESC = "desc";
    }
}
