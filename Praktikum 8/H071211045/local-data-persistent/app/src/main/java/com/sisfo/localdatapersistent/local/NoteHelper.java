package com.sisfo.localdatapersistent.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteHelper {
    private static volatile NoteHelper INSTANCE;
    private static SQLiteDatabase database;
    private static DatabaseHelper databaseHelper;

    private NoteHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    // Open connection to database
    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    // Close connection to database
    public void close() {
        databaseHelper.close();
        if (database.isOpen())
            database.close();
    }

    // Query all data from database
    public Cursor queryAll() {
        return database.query(
                DatabaseContract.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.NoteColumns._ID + " DESC"
        );
    }

    // Query data like title
    public Cursor queryByTitle(String title) {
        String query = String.format("SELECT * FROM %s WHERE %s LIKE ?", "notes", DatabaseContract.NoteColumns.TITLE);
        return database.rawQuery(query, new String[]{title + "%"});
    }

    // Insert data to table
    public long insert(ContentValues values) {
        return database.insert(DatabaseContract.TABLE_NAME, null, values);
    }

    // Update data to table
    public int update(String id, ContentValues values) {
        return database.update(DatabaseContract.TABLE_NAME, values, DatabaseContract.NoteColumns._ID + " = ?", new String[]{id});
    }

    // Delete data from table
    public int deleteById(String id) {
        return database.delete(DatabaseContract.TABLE_NAME, DatabaseContract.NoteColumns._ID + " = ?", new String[]{id});
    }

    // Get the context Instance
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


}
