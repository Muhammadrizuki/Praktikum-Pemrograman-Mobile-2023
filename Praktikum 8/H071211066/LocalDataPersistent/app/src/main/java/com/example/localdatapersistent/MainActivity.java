package com.example.localdatapersistent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ImageButton ibAdd;
    ArrayList<NoteModel> hasil = new ArrayList<>();
    NoteHelper noteHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibAdd = findViewById(R.id.ibAdd);

        SearchView searchView = findViewById(R.id.cari);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchData(s);
                return true;
            }
        });

        ibAdd.setOnClickListener(view -> {
            Intent form = new Intent(MainActivity.this, FormActivity.class);
            startActivity(form);
        });
        new LoadNotesAsync(this, notes -> {
            showCurrentNote(notes);
        }).execute();
    }

    private void searchData(String text) {
        if (!TextUtils.isEmpty(text)) {
            hasil = noteHelper.search(text);
            if(hasil != null){
                showCurrentNote(hasil);
            }
        } else {
            new LoadNotesAsync(this, notes -> {
                showCurrentNote(notes);
            }).execute();
        }
    }

    private void showCurrentNote(ArrayList<NoteModel> noteModel) {
        RecyclerView rvNote = findViewById(R.id.rv_note);
        rvNote.setHasFixedSize(true);
        rvNote.setLayoutManager(new LinearLayoutManager(this));
        if (noteModel != null) {
            NoteAdapter adapter = new NoteAdapter(noteModel);
            rvNote.setAdapter(adapter);
        }
    }

    private static class LoadNotesAsync {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadNotesCallback> weakCallback;

        private LoadNotesAsync(Context context, LoadNotesCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }
        void execute() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = weakContext.get();
                NoteHelper noteHelper = NoteHelper.getInstance(context);
                noteHelper.open();
                Cursor notesCursor = noteHelper.queryAll();
                ArrayList<NoteModel> notes =
                        MappingHelper.mapCursorToArrayList(notesCursor);
                noteHelper.close();
                if (notes != null){
                    handler.post(() -> weakCallback.get().postExecute(notes));
                }
            });
        }
    }
    interface LoadNotesCallback {
        void postExecute(ArrayList<NoteModel> notes);
    }
}