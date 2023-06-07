package com.sisfo.localdatapersistent.utils;

import com.sisfo.localdatapersistent.local.NoteHelper;
import com.sisfo.localdatapersistent.models.Note;

import java.util.ArrayList;

public interface NotesCallback {
    void onPreExecute();
    ArrayList<Note> onExecute(NoteHelper noteHelper);
    void onPostExecute(ArrayList<Note> notes);
}
