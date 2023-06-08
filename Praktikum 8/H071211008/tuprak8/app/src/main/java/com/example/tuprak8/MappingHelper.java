package com.example.tuprak8;

import android.database.Cursor;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<Notes> mapCursorToArrayList(Cursor cursor) {
        ArrayList<Notes> notess = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id =
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns._ID));
            String title =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns.TITLE));
            String description =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns.DESCRIPTION));
            String createdAt =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns.CREATEDAT));
            notess.add(new Notes(id, title, description, createdAt));
        }
        return notess;
    }
}
