package com.example.localdatapersistent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormActivity extends AppCompatActivity {

    public static final String EXTRA_NOTE= "extra_note";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    private NoteHelper noteHelper;
    private NoteModel noteModel;
    private EditText etJudul, etDesk;
    private boolean isEdit = false;
    private NoteModel notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etJudul = findViewById(R.id.et_judul);
        etDesk = findViewById(R.id.et_deskripsi);
        Button btnSubmit = findViewById(R.id.btn_submit);
        Button btnDelete = findViewById(R.id.btn_delete);

        noteHelper = NoteHelper.getInstance(getApplicationContext());
        noteHelper.open();

        noteModel = getIntent().getParcelableExtra(EXTRA_NOTE);
        if (noteModel != null){
            isEdit = true;
            etJudul.setText(noteModel.getJudul());
            etDesk.setText(noteModel.getDeskripsi());
            btnSubmit.setText("Update");
            btnDelete.setVisibility(View.VISIBLE);
        } else {
            btnSubmit.setText("Submit");
            btnDelete.setVisibility(View.GONE);
            noteModel = new NoteModel();
        }
        btnSubmit.setOnClickListener(view -> submit());
        btnDelete.setOnClickListener(view -> delete());
    }

    private void submit() {
        String judul = etJudul.getText().toString().trim();
        String deskripsi = etDesk.getText().toString().trim();
        if (judul.isEmpty()) {
            etJudul.setError("Please fill this field");
            return;
        }
        if (deskripsi.isEmpty()) {
            etDesk.setError("Please fill this field");
            return;
        }
        noteModel.setJudul(judul);
        noteModel.setDeskripsi(deskripsi);

        Date currentDate = new Date();
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern, Locale.getDefault());
        String createdAt = "Created at " + df.format(currentDate);

        Intent intent = new Intent(FormActivity.this, MainActivity.class);
        intent.putExtra(EXTRA_NOTE, noteModel);
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.NoteColumns.JUDUL, judul);
        values.put(DatabaseContract.NoteColumns.DESKRIPSI, deskripsi);

        if (isEdit) {
            String editedAt = "Edited at " + df.format(currentDate);
            values.put(DatabaseContract.NoteColumns.WAKTU, editedAt);
            long result = noteHelper.update(String.valueOf(noteModel.getId()), values);
            if (result > 0) {
                setResult(RESULT_UPDATE, intent);
                finish();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show();
            }
        } else {
            values.put(DatabaseContract.NoteColumns.WAKTU, createdAt);
            long result = noteHelper.insert(values);
            if (result > 0) {
                noteModel.setId((int) result);
                setResult(RESULT_ADD, intent);
                finish();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void delete() {
        long result = noteHelper.deleteById(String.valueOf(noteModel.getId()));
        if (result > 0) {
            Intent intent = new Intent(FormActivity.this, MainActivity.class);
            setResult(RESULT_DELETE, intent);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }
}