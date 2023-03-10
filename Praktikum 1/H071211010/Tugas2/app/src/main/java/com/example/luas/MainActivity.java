package com.example.luas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import kotlin.math.UMathKt;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    EditText jariBola, jariKerucut, tinggiKerucut, panjangBalok, tinggiBalok, lebarBalok;

    Button hitung;

    TextView hasil;

    String pilihan;

    ViewFlipper tampilan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        hitung = findViewById(R.id.hitung);
        hasil = findViewById(R.id.hasil);
        tampilan = findViewById(R.id.tampilan);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pilihan = spinner.getSelectedItem().toString();

                if (pilihan.equals("Bola")) {
                    tampilan.setDisplayedChild(0);

                } else if (pilihan.equals("Kerucut")) {
                    tampilan.setDisplayedChild(1);

                } else if (pilihan.equals("Balok")) {
                    tampilan.setDisplayedChild(2);

                } else {
                    tampilan.setDisplayedChild(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        hitung.setOnClickListener(new View.OnClickListener() {
            double v, j, t, p, l;

            @Override
            public void onClick(View view) {

                if (pilihan.equals("Bola")) {
                    jariBola = findViewById(R.id.jari_bola);
                    if (TextUtils.isEmpty(jariBola.getText().toString())) {
                        jariBola.setError("Isi dulu");
                    } else {
                        j = (double) Integer.parseInt(jariBola.getText().toString());

                        v = (4.0 / 3.0) * Math.PI * j * j * j;

                        hasil.setText(String.valueOf(v));
                    }


                } else if (pilihan.equals("Kerucut")) {
                    jariKerucut = findViewById(R.id.jari_kerucut);

                    tinggiKerucut = findViewById(R.id.tinggi_kerucut);
                    if (TextUtils.isEmpty(tinggiKerucut.getText().toString()) || TextUtils.isEmpty(jariKerucut.getText().toString())) {
                        if (TextUtils.isEmpty(tinggiKerucut.getText().toString())) {
                            tinggiKerucut.setError("Isi dulu bro");
                        }
                        if (TextUtils.isEmpty(jariKerucut.getText().toString())) {
                            jariKerucut.setError("Isi dulu bro");
                        }
                    } else {
                        j = (double) Integer.parseInt(jariKerucut.getText().toString());

                        t = (double) Integer.parseInt(tinggiKerucut.getText().toString());

                        v = (1.0 / 3.0) * Math.PI * j * j * t;

                        hasil.setText(String.valueOf(v));
                    }

                } else if (pilihan.equals("Balok")) {
                    tinggiBalok = findViewById(R.id.tinggi_balok);

                    panjangBalok = findViewById(R.id.panjang_balok);

                    lebarBalok = findViewById(R.id.lebar_balok);
                    if (TextUtils.isEmpty(tinggiBalok.getText().toString()) || TextUtils.isEmpty(panjangBalok.getText().toString()) || TextUtils.isEmpty(lebarBalok.getText().toString())) {
                        if (TextUtils.isEmpty(tinggiBalok.getText().toString())) {
                            tinggiBalok.setError("Isi dulu mas");
                        }
                        if (TextUtils.isEmpty(panjangBalok.getText().toString())) {
                            panjangBalok.setError("Isi dulu mas");
                        }
                        if (TextUtils.isEmpty(lebarBalok.getText().toString())) {
                            lebarBalok.setError("Isi dulu mas");
                        }
                    } else {
                        p = (double) Integer.parseInt(panjangBalok.getText().toString());

                        t = (double) Integer.parseInt(tinggiBalok.getText().toString());

                        l = (double) Integer.parseInt(lebarBalok.getText().toString());

                        v = p * l * t;

                        hasil.setText(String.valueOf(v));

                    }

                }
            }
        });
    }
}