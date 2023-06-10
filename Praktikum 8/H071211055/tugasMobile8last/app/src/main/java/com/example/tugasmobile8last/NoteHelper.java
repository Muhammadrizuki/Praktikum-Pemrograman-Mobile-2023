package com.example.tugasmobile8last;

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
        //synchronized dia memastikan tidak ada thread lain yang akses apk ini (tidak terjadi duplikasi instance)
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

    public ArrayList<NoteModel> getAllNotes() {
        ArrayList<NoteModel> note = new ArrayList<>();
        Cursor cursor = database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.NotesColumns._ID + " ASC"
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            NoteModel model = getNotesFromCursor(cursor);
            note.add(model);
            cursor.moveToNext();
        }
        cursor.close();
        return note;
    }

    private NoteModel getNotesFromCursor(Cursor cursor) {
        NoteModel model = new NoteModel();
        model.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns._ID)));
        model.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns.TITLE)));
        model.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns.DESC)));
        return model;
    }
    public Cursor queryById(String id) {
        return database.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.NotesColumns._ID + " = ?",
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
        return database.update(DATABASE_TABLE, values, DatabaseContract.NotesColumns._ID
                + " = ?", new String[]{id});
    }
    public int deleteById(String id) {
        return database.delete(DATABASE_TABLE, DatabaseContract.NotesColumns._ID + " = "
                + id, null);
    }
}
