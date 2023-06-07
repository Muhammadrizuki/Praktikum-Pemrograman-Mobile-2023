package com.example.localdatapersistent;

import android.database.Cursor;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<NoteModel> mapCursorToArrayList(Cursor cursor) {
        ArrayList<NoteModel> noteModels = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id =
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String judul =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.JUDUL));
            String waktu =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.WAKTU));
            String deskripsi =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESKRIPSI));
            noteModels.add(new NoteModel(id, judul, waktu, deskripsi));
        }
        return noteModels;
    }
}
