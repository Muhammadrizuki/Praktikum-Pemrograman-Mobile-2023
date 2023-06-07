package com.example.localdatapersistent;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "Note.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_NOTES =
            String.format(
                    "CREATE TABLE %s"
                            + " (%s INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + " %s TEXT NOT NULL,"
                            + " %s TEXT NOT NULL,"
                            + " %s TEXT NOT NULL)",
                    DatabaseContract.TABLE_NAME,
                    DatabaseContract.NoteColumns._ID,
                    DatabaseContract.NoteColumns.JUDUL,
                    DatabaseContract.NoteColumns.WAKTU,
                    DatabaseContract.NoteColumns.DESKRIPSI
            );
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +  DatabaseContract.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public Cursor cari(String text){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="Select * from " +DATABASE_NAME+" WHERE "+DatabaseContract.NoteColumns.JUDUL+" Like '"+text+"%'";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
}
