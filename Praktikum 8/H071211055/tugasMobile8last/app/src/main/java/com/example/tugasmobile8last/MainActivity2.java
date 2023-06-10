package com.example.tugasmobile8last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_NOTES = "extra_notes";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    private NoteHelper noteHelper;
    private NoteModel model;
    private EditText Title, Desc;
    private boolean isEdit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Title = findViewById(R.id.title);
        Desc = findViewById(R.id.description);
        Button btnSubmit = findViewById(R.id.btn_submit);
        Button btnDelete = findViewById(R.id.btn_delete);
        noteHelper = NoteHelper.getInstance(getApplicationContext());
        noteHelper.open();
        model = getIntent().getParcelableExtra(EXTRA_NOTES);
        if (model != null) {
            isEdit = true;
        } else {
            model = new NoteModel();
        }
        String buttonTitle;
        if (isEdit) {
            buttonTitle = "Update";
            if (model != null) {
                Title.setText(model.getTitle());
                Desc.setText(model.getDesc());
            }
            btnDelete.setVisibility(View.VISIBLE);
        } else {
            buttonTitle = "Submit";
        }
        btnSubmit.setText(buttonTitle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        btnSubmit.setOnClickListener(view -> submit());
        btnDelete.setOnClickListener(view -> delete());
    }
    private void submit() {
        String title = Title.getText().toString().trim();
        String desc = Desc.getText().toString().trim();
        if (title.isEmpty()) {
            Title.setError("Please fill this field");
            return;
        }
        if (desc.isEmpty()) {
            Desc.setError("Please fill this field");
            return;
        }
        model.setTitle(title);
        model.setDesc(desc);
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOTES, model);
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.NotesColumns.TITLE, title);
        values.put(DatabaseContract.NotesColumns.DESC, desc);
        if (isEdit) {
            long result = noteHelper.update(String.valueOf(model.getId()), values);
            if (result > 0) {
                setResult(RESULT_UPDATE, intent);
                finish();
            } else {
                Toast.makeText(this, "Gagal menghapus note!", Toast.LENGTH_SHORT).show();
            }
        } else {
            long result = noteHelper.insert(values);
            if (result > 0) {
                model.setId((int) result);
                setResult(RESULT_ADD, intent);
                finish();
            } else {
                Toast.makeText(this, "Gagal menambahkan note baru!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void delete() {
        long result = noteHelper.deleteById(String.valueOf(model.getId()));
        if (result > 0) {
            Intent intent = new Intent();
            setResult(RESULT_DELETE, intent);
            finish();
        } else {
            Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }

}
