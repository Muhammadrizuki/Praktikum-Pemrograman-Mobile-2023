package com.example.tugasmobile8last;

import android.database.Cursor;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<NoteModel> mapCursorToArrayList(Cursor cursor) {
        ArrayList<NoteModel> note = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns._ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns.TITLE));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumns.DESC));
            note.add(new NoteModel(id, title, description));
        }
        return note;
        //cursor dia sebuah pointer ke query
    }
}
