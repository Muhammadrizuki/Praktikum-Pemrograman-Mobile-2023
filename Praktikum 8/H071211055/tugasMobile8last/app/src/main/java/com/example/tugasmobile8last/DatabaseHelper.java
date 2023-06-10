package com.example.tugasmobile8last;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "Student.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_STUDENT =
            String.format(
                    "CREATE TABLE %s"
                            + " (%s INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + " %s TEXT NOT NULL,"
                            + " %s TEXT NOT NULL)",
                    DatabaseContract.TABLE_NAME,
                    DatabaseContract.NotesColumns._ID,
                    DatabaseContract.NotesColumns.TITLE,
                    DatabaseContract.NotesColumns.DESC
//                        Date currentDate = new Date();
//    String pattern = "MM/dd/yyyy HH:mm:ss";
//    DateFormat df = new SimpleDateFormat(pattern, Locale.getDefault());
//    String createdAt = "Created at " + df.format(currentDate);

            );
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_STUDENT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}