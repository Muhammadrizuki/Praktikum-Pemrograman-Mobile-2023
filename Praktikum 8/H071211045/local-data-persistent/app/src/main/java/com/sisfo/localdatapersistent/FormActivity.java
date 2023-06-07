package com.sisfo.localdatapersistent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.sisfo.localdatapersistent.databinding.ActivityFormBinding;
import com.sisfo.localdatapersistent.local.DatabaseContract;
import com.sisfo.localdatapersistent.local.NoteHelper;
import com.sisfo.localdatapersistent.models.Note;
import com.sisfo.localdatapersistent.utils.Key;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class FormActivity extends AppCompatActivity {

    private ActivityFormBinding binding;

    private Note note;
    private NoteHelper noteHelper;

    private boolean isEdit = false;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());

        note = getIntent().getParcelableExtra(Key.EXTRA_NOTE);

        noteHelper = NoteHelper.getInstance(getApplicationContext());
        noteHelper.open();

        binding.btnSubmit.setOnClickListener(v -> submitNote());
        binding.btnDelete.setOnClickListener(v -> deleteNote());

        parseNote(note);
        setContentView(binding.getRoot());
    }

    private void parseNote(Note note) {
        if (note != null) {
            this.isEdit = true;
            this.position = getIntent().getIntExtra(Key.EXTRA_POSITION, 0);
            binding.etTitle.setText(note.getTitle());
            binding.etDescription.setText(note.getDescription());
            binding.btnSubmit.setText(getString(R.string.str_update));
            binding.btnDelete.setVisibility(View.VISIBLE);

        } else {
            this.isEdit = false;
            this.note = new Note();
            binding.btnSubmit.setText(getString(R.string.str_submit));
            binding.btnDelete.setVisibility(View.GONE);
        }
    }

    private void submitNote() {
        String title = Objects.requireNonNull(binding.etTitle.getText()).toString().trim();
        String description = Objects.requireNonNull(binding.etDescription.getText()).toString().trim();

        if (TextUtils.isEmpty(title)) {
            binding.etTitle.setError(getString(R.string.str_required));
            return;
        }

        note.setTitle(title);
        note.setDescription(description);

        String currentDate = getCurrentDate();
        String date = String.format((!isEdit ?
                getString(R.string.str_created_at) : getString(R.string.str_updated_at)
                ) + " %s", currentDate);

        Intent intent = new Intent();
        intent.putExtra(Key.EXTRA_NOTE, note);
        intent.putExtra(Key.EXTRA_POSITION, position);

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.NoteColumns.TITLE, title);
        values.put(DatabaseContract.NoteColumns.DESCRIPTION, description);
        values.put(DatabaseContract.NoteColumns.DATE, date);

        if (!isEdit) { // ADD
            long result = noteHelper.insert(values);
            if (result > 0) {
                note.setId((int) result);
                note.setDate(date);
                setResult(Key.RESULT_ADD, intent);
                finish();
                return;
            }
            Toast.makeText(this, getString(R.string.str_failed_insert), Toast.LENGTH_SHORT).show();

        } else { // EDIT
            long result = noteHelper.update(String.valueOf(note.getId()), values);
            if (result > 0) {
                setResult(Key.RESULT_UPDATE, intent);
                finish();
                return;
            }
            Toast.makeText(this, getString(R.string.str_failed_update), Toast.LENGTH_SHORT).show();

        }
    }

    private void deleteNote() {
        if (!isEdit) return;

        long result = noteHelper.deleteById(String.valueOf(note.getId()));
        if (result > 0) {
            Intent intent = new Intent();
            intent.putExtra(Key.EXTRA_POSITION, position);
            setResult(Key.RESULT_DELETE, intent);
            finish();
            return;
        }
        Toast.makeText(this, getString(R.string.str_failed_delete), Toast.LENGTH_SHORT).show();
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(new Date());
    }
}