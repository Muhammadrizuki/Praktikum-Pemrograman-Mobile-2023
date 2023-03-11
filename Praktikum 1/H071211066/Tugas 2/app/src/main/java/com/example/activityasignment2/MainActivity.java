package com.example.activityasignment2;

import static com.example.activityasignment2.R.*;
import static com.example.activityasignment2.R.id.spinner;
import static com.example.activityasignment2.R.id.text_panjang;
import static com.example.activityasignment2.R.id.text_tinggi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView text_jari_jari, text_tinggi, text_panjang, hasil;
    EditText jari_jari, tinggi, panjang;

    Button hitung;

    String[] bangun_ruang = {"Bola", "Kerucut", "Balok"};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        spinner = findViewById(R.id.spinner);

        text_jari_jari = findViewById(id.text_jari_jari);
        text_tinggi = findViewById(id.text_tinggi);
        text_panjang = findViewById(id.text_panjang);

        jari_jari = findViewById(id.jari_jari);
        tinggi = findViewById(id.tinggi);
        panjang = findViewById(id.panjang);

        hasil = findViewById(id.hasil);

        hitung = findViewById(id.hitung);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,bangun_ruang);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();

                if (selectedItem == "Kerucut") {
                    text_tinggi.setVisibility(View.VISIBLE);
                    tinggi.setVisibility(View.VISIBLE);
                    text_tinggi.setText("Tinggi");
                    text_jari_jari.setText("Jari-jari");
                    text_panjang.setVisibility(View.GONE);
                    panjang.setVisibility(View.GONE);
                    hasil.setText("Hasil");
                } else if (selectedItem == "Balok") {
                    text_tinggi.setVisibility(View.VISIBLE);
                    tinggi.setVisibility(View.VISIBLE);
                    text_panjang.setVisibility(View.VISIBLE);
                    panjang.setVisibility(View.VISIBLE);
                    text_jari_jari.setText("Panjang");
                    text_tinggi.setText("Lebar");
                    text_panjang.setText("Tinggi");
                    hasil.setText("Hasil");
                } else {
                    text_tinggi.setVisibility(View.GONE);
                    tinggi.setVisibility(View.GONE);
                    text_jari_jari.setText("Jari-jari");
                    text_panjang.setVisibility(View.GONE);
                    panjang.setVisibility(View.GONE);
                    hasil.setText("Hasil");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String njari_jari = jari_jari.getText().toString();
                String ntinggi = tinggi.getText().toString();
                String npanjang = panjang.getText().toString();

                String selectedItem = spinner.getSelectedItem().toString();

                double jari_jari1, tinggi2, panjang3, hasil2;

                if (selectedItem == "Kerucut") {
                    if (njari_jari.isEmpty() && ntinggi.isEmpty()) {
                        jari_jari.setError("Field ini tidak boleh kosong");
                        tinggi.setError("Field ini tidak boleh kosong");
                        hasil.setText("Hasil");
                    } else if (njari_jari.isEmpty()) {
                        jari_jari.setError("Field ini tidak boleh kosong");
                        hasil.setText("Hasil");
                    } else if (ntinggi.isEmpty()) {
                        tinggi.setError("Field ini tidak boleh kosong");
                        hasil.setText("Hasil");
                    } else {
                        jari_jari1 = Double.parseDouble(jari_jari.getText().toString());
                        tinggi2 = Double.parseDouble(tinggi.getText().toString());

                        hasil2 = (Math.PI * Math.pow(jari_jari1, 2) * tinggi2) / 3;

                        hasil.setText(String.format("%.2f", hasil2));
                    }

                } else if (selectedItem == "Balok") {
                    if (njari_jari.isEmpty() && ntinggi.isEmpty() && npanjang.isEmpty()) {
                        jari_jari.setError("Field ini tidak boleh kosong");
                        tinggi.setError("Field ini tidak boleh kosong");
                        panjang.setError("Field ini tidak boleh kosong");
                        hasil.setText("Hasil");
                    } else if (njari_jari.isEmpty()) {
                        if (ntinggi.isEmpty()) {
                            jari_jari.setError("Field ini tidak boleh kosong");
                            tinggi.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        } else if (npanjang.isEmpty()) {
                            jari_jari.setError("Field ini tidak boleh kosong");
                            panjang.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        } else {
                            jari_jari.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        }
                    } else if (ntinggi.isEmpty()) {
                        if (njari_jari.isEmpty()) {
                            tinggi.setError("Field ini tidak boleh kosong");
                            jari_jari.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        } else if (npanjang.isEmpty()) {
                            tinggi.setError("Field ini tidak boleh kosong");
                            panjang.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        } else {
                            tinggi.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        }
                    } else if (npanjang.isEmpty()) {
                        if (ntinggi.isEmpty()) {
                            panjang.setError("Field ini tidak boleh kosong");
                            tinggi.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        } else if (njari_jari.isEmpty()) {
                            panjang.setError("Field ini tidak boleh kosong");
                            jari_jari.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        } else {
                            panjang.setError("Field ini tidak boleh kosong");
                            hasil.setText("Hasil");
                        }
                    } else {
                        panjang3 = Double.parseDouble(panjang.getText().toString());
                        tinggi2 = Double.parseDouble(tinggi.getText().toString());
                        jari_jari1 = Double.parseDouble(jari_jari.getText().toString());

                        hasil2 = jari_jari1 * tinggi2 * panjang3;

                        hasil.setText(String.format("%.2f", hasil2));
                    }
                } else {
                    if (njari_jari.isEmpty()) {
                        jari_jari.setError("Field ini tidak boleh kosong");
                        hasil.setText("Hasil");
                    } else {
                        jari_jari1 = Double.parseDouble(jari_jari.getText().toString());

                        hasil2 = (4 * Math.PI * Math.pow(jari_jari1, 3)) / 3;

                        hasil.setText(String.format("%.2f", hasil2));
                    }
                }
            }
        });


    }

}