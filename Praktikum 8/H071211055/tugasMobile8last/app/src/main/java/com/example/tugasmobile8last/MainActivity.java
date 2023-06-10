package com.example.tugasmobile8last;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_NOTES = "extra_notes";
    private RecyclerView rvNote;
    private AdapterNote adapterNote;
    private TextView Note;
    private CardView Add;
    private EditText searchData;
    private LinearLayout search;
    private ImageView cancel;
    private ArrayList<NoteModel> note;

    private NoteHelper noteHelper;

    private final ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getData() != null) {
                            switch (result.getResultCode()) {
                                case MainActivity2.RESULT_ADD:
                                    note = new ArrayList<>();
                                    note.add((NoteModel) result.getData().getParcelableExtra(MainActivity.EXTRA_NOTES));
                                    showCurrentUser(note);
                                    Toast.makeText(this, "Note added successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                case MainActivity2.RESULT_UPDATE:
                                    note = new ArrayList<>();
                                    note.add((NoteModel) result.getData().getParcelableExtra(MainActivity.EXTRA_NOTES));
                                    showCurrentUser(note);
                                    Toast.makeText(this, "Note updated successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                case MainActivity2.RESULT_DELETE:
                                    note = null;
                                    showCurrentUser(note);
                                    Toast.makeText(this, "Note deleted successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNote = findViewById(R.id.rv);
        Note = findViewById(R.id.tv_note);
        Add = findViewById(R.id.add);
        searchData = findViewById(R.id.et_search);
        search = findViewById(R.id.search);
        cancel = findViewById(R.id.iv_cancelSearch);

        noteHelper = NoteHelper.getInstance(this);
        noteHelper.open();


        adapterNote = new AdapterNote();
        rvNote.setAdapter(adapterNote);
        rvNote.setLayoutManager(new LinearLayoutManager(this));

        Add.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            resultLauncher.launch(intent);
        });

        cancel.setOnClickListener(v -> {
            searchData.setText("");
        });

        searchData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchNotes(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotesFromDatabase();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        noteHelper.close();
    }

    private void loadNotesFromDatabase() {
        note = noteHelper.getAllNotes();
        showCurrentUser(note);
    }

    private void showCurrentUser(ArrayList<NoteModel> note) {
        adapterNote.setData(note);

        if (note != null && !note.isEmpty()) {
            Note.setVisibility(View.GONE);
            search.setVisibility(View.VISIBLE);
        } else {
            search.setVisibility(View.GONE);
            Note.setVisibility(View.VISIBLE);
        }
    }

    private void searchNotes(String keyword) {
        ArrayList<NoteModel> filteredNotes = new ArrayList<>();

        for (NoteModel noteModel : note) {
            if (noteModel.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    noteModel.getDesc().toLowerCase().contains(keyword.toLowerCase())) {
                filteredNotes.add(noteModel);
            }
        }

        adapterNote.setData(filteredNotes);
    }
}