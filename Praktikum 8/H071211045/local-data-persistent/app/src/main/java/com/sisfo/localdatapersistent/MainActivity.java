package com.sisfo.localdatapersistent;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.textfield.TextInputEditText;
import com.sisfo.localdatapersistent.adapters.NoteAdapter;
import com.sisfo.localdatapersistent.databinding.ActivityMainBinding;
import com.sisfo.localdatapersistent.local.NoteHelper;
import com.sisfo.localdatapersistent.models.Note;
import com.sisfo.localdatapersistent.utils.Key;
import com.sisfo.localdatapersistent.utils.MappingHelper;
import com.sisfo.localdatapersistent.utils.NotesAsync;
import com.sisfo.localdatapersistent.utils.NotesCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NoteAdapter adapter;
    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    public void onSaveInstanceState(Bundle output) {
        super.onSaveInstanceState(output);
        output.putParcelableArrayList("NOTES", adapter.getNotes());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        resultLauncher = getLauncherReference();
        adapter = new NoteAdapter(this::getNoteIntent);

        binding.rvNotes.setLayoutManager(new LinearLayoutManager(this));
        binding.rvNotes.setAdapter(this.adapter);
        binding.fabAdd.setOnClickListener(v ->  makeNoteIntent());


        checkData(savedInstanceState);
        initiateSearchListener(binding.etSearch);
    }

    private void initiateSearchListener(TextInputEditText search) {
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                querySearchNotes(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void checkData(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            loadNotes();
        else {
            ArrayList<Note> notes = savedInstanceState.getParcelableArrayList("NOTES");
            if (notes != null)
                adapter.setNotes(notes);
            else
                widgetHelper("SHOW_EMPTY_MSG");

        }
    }

    private void makeNoteIntent() {
        Intent intent = new Intent(this, FormActivity.class);
        resultLauncher.launch(intent);
    }

    private void getNoteIntent(Note note, int position) {
        Intent intent = new Intent(this, FormActivity.class);
        intent.putExtra(Key.EXTRA_NOTE, note);
        intent.putExtra(Key.EXTRA_POSITION, position);
        resultLauncher.launch(intent);
    }

    private ActivityResultLauncher<Intent> getLauncherReference() {
        return registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getData() != null) {
                System.out.println("RESULT -> " + result.getResultCode());
                Note note;

                if (result.getResultCode() == Key.RESULT_ADD) { // ADD
                    note = result.getData().getParcelableExtra(Key.EXTRA_NOTE);
                    adapter.addNote(note);
                    binding.rvNotes.smoothScrollToPosition(adapter.getItemCount() - 1);
                    Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show();

                } else if (result.getResultCode() == Key.RESULT_UPDATE) { // UPDATE
                    note = result.getData().getParcelableExtra(Key.EXTRA_NOTE);
                    int position = result.getData().getIntExtra(Key.EXTRA_POSITION, 0);
                    adapter.updateNote(position, note);
                    binding.rvNotes.smoothScrollToPosition(position);
                    Toast.makeText(this, "Item updated successfully", Toast.LENGTH_SHORT).show();

                } else if (result.getResultCode() == Key.RESULT_DELETE) { // DELETE
                    int position = result.getData().getIntExtra(Key.EXTRA_POSITION, 0);
                    adapter.removeNote(position);
                    Toast.makeText(this, "Item removed successfully", Toast.LENGTH_SHORT).show();
                }

                if (adapter.getItemCount() < 1) {
                    widgetHelper("SHOW_EMPTY_MSG");
                } else {
                    widgetHelper("HIDE_EMPTY_MSG");
                }

                if (binding.etSearch.getText() != null)
                    querySearchNotes(binding.etSearch.getText().toString());

            }
        });
    }

    private void querySearchNotes(String query) {
        new NotesAsync(this, new NotesCallback() {
            @Override
            public void onPreExecute() {
                widgetHelper("ON_LOADING");
            }
            @Override
            public ArrayList<Note> onExecute(NoteHelper noteHelper) {
                if (TextUtils.isEmpty(query))
                    return MappingHelper.cursorToArrayList(noteHelper.queryByTitle(""));
                else
                    return MappingHelper.cursorToArrayList(noteHelper.queryByTitle(query));
            }
            @Override
            public void onPostExecute(ArrayList<Note> notes) {
                widgetHelper("LOADING_DONE");

                if (notes.size() > 0) {
                    adapter.setNotes(notes);
//                    widgetHelper(-2);
                } else {
                    adapter.setNotes(new ArrayList<>());
//                    widgetHelper(-1);
                }
            }
        }).execute();
    }

    private void loadNotes() {
        new NotesAsync(this, new NotesCallback() {
            @Override
            public void onPreExecute() {
                widgetHelper("ON_LOADING");
            }
            @Override
            public ArrayList<Note> onExecute(NoteHelper noteHelper) {
                return MappingHelper.cursorToArrayList(noteHelper.queryAll());
            }
            @Override
            public void onPostExecute(ArrayList<Note> notes) {
                widgetHelper("LOADING_DONE");

                if (notes.size() > 0) {
                    adapter.setNotes(notes);
                    widgetHelper("HIDE_EMPTY_MSG");
                    return;
                }
                adapter.setNotes(new ArrayList<>());
                widgetHelper("SHOW_EMPTY_MSG");
            }
        }).execute();
    }

    private void widgetHelper(String condition) {
        switch (condition) {
            case "ON_LOADING": // Show Progress Bar and Hide Recycler View
                binding.progressBar.setVisibility(View.VISIBLE);
                binding.rvNotes.setVisibility(View.GONE);
                break;
            case "LOADING_DONE": // Hide Progress Bar and Show Recycler View
                binding.progressBar.setVisibility(View.GONE);
                binding.rvNotes.setVisibility(View.VISIBLE);
                break;
            case "SHOW_EMPTY_MSG": // Show Empty Text and Hide search bar
                binding.tvEmpty.setVisibility(View.VISIBLE);
                binding.tfSearch.setVisibility(View.GONE);
                break;
            case "HIDE_EMPTY_MSG": // Hide Empty Text and Show search bar
                binding.tvEmpty.setVisibility(View.GONE);
                binding.tfSearch.setVisibility(View.VISIBLE);
                break;
        }
    }
}