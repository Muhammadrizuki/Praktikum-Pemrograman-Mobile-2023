package com.sisfo.localdatapersistent.utils;

import android.database.Cursor;

import com.sisfo.localdatapersistent.local.DatabaseContract;
import com.sisfo.localdatapersistent.models.Note;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<Note> cursorToArrayList(Cursor cursor) {
        ArrayList<Note> notesList = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE));

            notesList.add(new Note (id, title, description, date));
        }

        return notesList;
    }
}
