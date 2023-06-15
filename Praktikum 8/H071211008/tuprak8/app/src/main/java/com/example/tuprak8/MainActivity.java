package com.example.tuprak8;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    AdapterNotes adapterNotes;
    private TextView tv_first;
    private CardView cv_add;
    private SearchView sv_cari;
    private ProgressBar progressBar;
    private  ArrayList<Notes> note;
    private NotesHelper notesHelper;
    Executor executor;
    Handler handler;
    Notes ininote;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_notes);
        tv_first = findViewById(R.id.tv_first);
        cv_add = findViewById(R.id.cv_add);
        sv_cari = findViewById(R.id.sv_cari);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        sv_cari.setFocusable(true);
        sv_cari.setIconified(false);
        sv_cari.requestFocus();
        adapterNotes = new AdapterNotes();

        notesHelper = NotesHelper.getInstance(this);
        notesHelper.open();

        rv.setAdapter(adapterNotes);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        cv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        if (rv != null){
            tv_first.setVisibility(View.GONE);
            cv_add.setVisibility(View.VISIBLE);
        }
        new LoadStudentsAsync(this, notess -> {
            if (notess.size() > 0) {
                note = notess;
            } else {
                note = null;
            }
            if (note != null){
                showCurrentUser(note);
            }
            else {
                showCurrentUser(new ArrayList<>());
                Toast.makeText(this, "kosong?", Toast.LENGTH_SHORT).show();
            }

        }).execute();

        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

        sv_cari.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchData(newText);
                return true;
            }
        });
    }

    private void showCurrentUser(ArrayList<Notes> notes) {
        adapterNotes.setData(notes);

        if (notes.size() > 0) {
            tv_first.setVisibility(View.GONE);
        } else {
            tv_first.setVisibility(View.VISIBLE);
        }
    }

    private static class LoadStudentsAsync {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadStudentsCallback> weakCallback;
        private LoadStudentsAsync(Context context, LoadStudentsCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }
        void execute() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = weakContext.get();
                NotesHelper notesHelper = NotesHelper.getInstance(context);
                notesHelper.open();
                ArrayList<Notes> notesList = notesHelper.getAllNotes();
                notesHelper.close();
                handler.post(() -> weakCallback.get().postExecute(notesList));
            });
        }
    }
    interface LoadStudentsCallback {
        void postExecute(ArrayList<Notes> notess);
    }

    private void searchData(String searchText) {
        if (!TextUtils.isEmpty(searchText)) {
            progressBar.setVisibility(View.VISIBLE);

            executor.execute(() -> {
                ArrayList<Notes> searchResults = notesHelper.searchNotes(searchText);

                handler.post(() -> {
                    adapterNotes.setData(searchResults);
                    progressBar.setVisibility(View.GONE);
                });
            });
        } else {
            // Jika teks pencarian kosong, tampilkan semua data
            showCurrentUser(note);
        }
    }

}