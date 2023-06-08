package com.sisfo.localdatapersistent.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.sisfo.localdatapersistent.local.NoteHelper;
import com.sisfo.localdatapersistent.models.Note;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NotesAsync {
    private final WeakReference<NotesCallback> callback;
    private final WeakReference<Context> context;

    public NotesAsync(Context context, NotesCallback callback) {
        this.context = new WeakReference<>(context);
        this.callback = new WeakReference<>(callback);
    }

    public void execute() {
        // (Before) Pre-Execute
        this.callback.get().onPreExecute();

        // (On) Execute
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            NoteHelper noteHelper = NoteHelper.getInstance(context.get());
            noteHelper.open();
            ArrayList<Note> result = callback.get().onExecute(noteHelper);
            noteHelper.close();
            handler.post(() -> {
                // (After) Post-Execute
                fetchNotesBy(result);
            });
        });
    }

    private void fetchNotesBy(ArrayList<Note> notes) {
        this.callback.get().onPostExecute(notes);
    }
}

