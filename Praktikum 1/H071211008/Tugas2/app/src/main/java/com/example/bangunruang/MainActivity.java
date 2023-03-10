package com.example.bangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button btn_hitung;
    private TextView tv_hasil;
    private LinearLayout ll_jarijari, ll_lebar, ll_tinggi, ll_panjang;
    private EditText et_jari, et_panjang, et_lebar, et_tinggi;
    private ArrayList<String> bruang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ll_jarijari = findViewById(R.id.ll_jarijari);
        ll_lebar = findViewById(R.id.ll_lebar);
        ll_tinggi = findViewById(R.id.ll_tinggi);
        ll_panjang = findViewById(R.id.ll_panjang);
        tv_hasil = findViewById(R.id.tv_hasil);
        btn_hitung = findViewById(R.id.btn_hitung);
        et_jari = findViewById(R.id.et_jari);
        et_panjang = findViewById(R.id.et_panjang);
        et_lebar = findViewById(R.id.et_lebar);
        et_tinggi = findViewById(R.id.et_tinggi);

        bruang = new ArrayList<>();
        bruang.add("Bola");
        bruang.add("Kerucut");
        bruang.add("Balok");

        ArrayAdapter<String>adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, bruang);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                String value = parent.getItemAtPosition(i).toString();
                if(value == "Bola"){
                    ll_lebar.setVisibility(View.GONE);
                    ll_tinggi.setVisibility(View.GONE);
                    ll_panjang.setVisibility(View.GONE);
                    ll_jarijari.setVisibility(View.VISIBLE);
                    tv_hasil.setText("Hasil");
                } else if (value == "Kerucut") {
                    ll_lebar.setVisibility(View.GONE);
                    ll_panjang.setVisibility(View.GONE);
                    ll_jarijari.setVisibility(View.VISIBLE);
                    ll_tinggi.setVisibility(View.VISIBLE);
                    tv_hasil.setText("Hasil");
                }else {
                    ll_jarijari.setVisibility(View.GONE);
                    ll_lebar.setVisibility(View.VISIBLE);
                    ll_tinggi.setVisibility(View.VISIBLE);
                    ll_panjang.setVisibility(View.VISIBLE);
                    tv_hasil.setText("Hasil");
                }
                Toast.makeText(getApplicationContext(), adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jarijari = et_jari.getText().toString();
                String panjang = et_panjang.getText().toString();
                String lebar = et_lebar.getText().toString();
                String tinggi = et_tinggi.getText().toString();
                String pilih = spinner.getSelectedItem().toString();

                if (pilih == "Bola"){
                   try {
                       if(jarijari.isEmpty()){
                           et_jari.setError("Data tidak boleh kosong!");
                           Toast.makeText(MainActivity.this, "Masukkan jari-jari bola!", Toast.LENGTH_SHORT).show();
                       }else {
                           int jari = Integer.valueOf(et_jari.getText().toString());

                           double Hasil = 4.00 / 3.00 * jari * jari * jari * 3.14;
                           tv_hasil.setText((String.format("%.2f", Hasil)));
                       }
                   }catch (NumberFormatException ex){
                        Toast.makeText(MainActivity.this, "Imputan terlalu besar", Toast.LENGTH_SHORT).show();
                   }
                } else if (pilih == "Kerucut") {
                    try {
                        boolean isEmpty = false;
                        if(tinggi.isEmpty()){
                            et_tinggi.setError("Data tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan tinggi kerucut!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }if(jarijari.isEmpty()){
                            et_jari.setError("Data tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan jari-jari kerucut!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }if(!isEmpty){
                            Long jari = Long.valueOf(et_jari.getText().toString());
                            Long Tinggi = Long.valueOf(et_tinggi.getText().toString());

                            double Hasil = 1.00 /3.00 * jari * jari * Tinggi * 3.14;
                            tv_hasil.setText(String.format("%.2f", Hasil));
                        }
                    }catch (NumberFormatException ex){
                        Toast.makeText(MainActivity.this, "Imputan terlalu besar", Toast.LENGTH_SHORT).show();
                    }
                } else if (pilih == "Balok") {
                    try {
                        boolean isEmpty = false;
                        if (panjang.isEmpty()){
                            et_panjang.setError("Data tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan panjang balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }if (tinggi.isEmpty()){
                            et_tinggi.setError("Data tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan tinggi balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }if(lebar.isEmpty()){
                            et_lebar.setError("Data tidak boleh kosong!");
                            Toast.makeText(MainActivity.this, "Masukkan lebar balok!", Toast.LENGTH_SHORT).show();
                            isEmpty = true;
                        }if(!isEmpty){
                            int Panjang = Integer.valueOf(et_panjang.getText().toString());
                            int Lebar = Integer.valueOf(et_lebar.getText().toString());
                            int Tinggi = Integer.valueOf(et_tinggi.getText().toString());

                            int Hasil = Panjang * Lebar * Tinggi;
                            tv_hasil.setText(String.valueOf(Hasil));
                        }
                    }catch (NumberFormatException ex){
                        Toast.makeText(MainActivity.this, "imputan terlalu besar", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}