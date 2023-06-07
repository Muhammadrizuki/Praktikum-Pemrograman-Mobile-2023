package com.example.localdatapersistent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NoteHelper {
    private static final String DATABASE_TABLE = DatabaseContract.TABLE_NAME;
    private static DatabaseHelper databaseHelper;
    private static SQLiteDatabase database;
    private static volatile NoteHelper INSTANCE;

    private NoteHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }
    public static NoteHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NoteHelper(context);
                }
            }
        }
        return INSTANCE;
    }
    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }
    public void close() {
        databaseHelper.close();
        if (database.isOpen()) {
            database.close();
        }
    }
    public Cursor queryAll() {
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.NoteColumns._ID + " DESC"
        );
    }
    public Cursor queryById(String id) {
        return database.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.NoteColumns._ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }
    public long insert(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }
    public int update(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, DatabaseContract.NoteColumns._ID
                + " = ?", new String[]{id});
    }
    public int deleteById(String id) {
        return database.delete(DATABASE_TABLE, DatabaseContract.NoteColumns._ID + " = "
                + id, null);
    }
    public static ArrayList<NoteModel> search(String text){
        ArrayList<NoteModel> hasil = new ArrayList<>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseContract.TABLE_NAME + " WHERE " + DatabaseContract.NoteColumns.JUDUL + " LIKE '" + text + "%'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                NoteModel noteModel = getNotesFromCursor(cursor);
                hasil.add(noteModel);
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return hasil;
    }
    private static NoteModel getNotesFromCursor(Cursor cursor) {
        NoteModel noteModel = new NoteModel();
        noteModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID)));
        noteModel.setJudul(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.JUDUL)));
        noteModel.setDeskripsi(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESKRIPSI)));
        noteModel.setWaktu(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.WAKTU)));
        return noteModel;
    }
}
