package com.example.bangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Double JariJari;
    Double Panjang;
    Double Lebar;
    Double Tinggi;
    LinearLayout lLayoutInput;
    Double Volume;
    LinearLayout lLayoutVolume;
    Button tombol;
    TextView jinp1;
    EditText vinputan1;
    TextView jinp2;
    EditText vinputan2;
    TextView jinp3;
    EditText vinputan3;
    TextView hasil;
    Spinner corespin;
    TextView hitungapa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tombol = (Button) findViewById(R.id.btnHitung);
        jinp1 = (TextView) findViewById(R.id.judulinputan1);
        vinputan1 = (EditText) findViewById(R.id.inputan1);
        jinp2 = (TextView) findViewById(R.id.judulinputan2);
        vinputan2 = (EditText) findViewById(R.id.inputan2);
        jinp3 = (TextView) findViewById(R.id.judulinputan3);
        vinputan3 = (EditText) findViewById(R.id.inputan3);
        hasil = (TextView) findViewById(R.id.tvVolume);
        corespin = (Spinner) findViewById(R.id.spinnerbr);
        lLayoutInput = (LinearLayout) findViewById(R.id.llinput);
        lLayoutVolume = (LinearLayout) findViewById(R.id.llVolume);
        hitungapa = (TextView) findViewById(R.id.textView2);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        corespin.setAdapter(adapter);

        corespin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        lLayoutInput.setVisibility(View.VISIBLE);
                        lLayoutVolume.setVisibility(View.VISIBLE);
                        hitungapa.setText("Menghitung Volume Bola");
                        jinp1.setText("Jari-jari");
                        vinputan1.setHint("Masukkan Jari-jari Bola");
                        jinp2.setText("");
                        vinputan2.setHint("");
                        vinputan2.setVisibility(View.GONE);
                        jinp3.setText("");
                        vinputan3.setHint("");
                        vinputan3.setVisibility(View.GONE);
                        tombol.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        lLayoutInput.setVisibility(View.VISIBLE);
                        lLayoutVolume.setVisibility(View.VISIBLE);
                        hitungapa.setText("Menghitung Volume Balok");
                        jinp1.setText("Panjang");
                        vinputan1.setHint("Masukkan Panjang Balok");
                        jinp2.setText("Lebar");
                        vinputan2.setHint("Masukkan Lebar Balok");
                        vinputan2.setVisibility(View.VISIBLE);
                        jinp3.setText("Tinggi");
                        vinputan3.setHint("Masukkan Tinggi Balok");
                        vinputan3.setVisibility(View.VISIBLE);
                        tombol.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        lLayoutInput.setVisibility(View.VISIBLE);
                        lLayoutVolume.setVisibility(View.VISIBLE);
                        hitungapa.setText("Menghitung Volume Kerucut");
                        jinp1.setText("Jari-jari");
                        vinputan1.setHint("Masukkan Jari-jari Kerucut");
                        jinp2.setText("Tinggi");
                        vinputan2.setHint("Masukkan Tinggi Kerucut");
                        vinputan2.setVisibility(View.VISIBLE);
                        jinp3.setText("");
                        vinputan3.setHint("");
                        vinputan3.setVisibility(View.GONE);
                        tombol.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("Bola".equals(corespin.getSelectedItem().toString())) {
                    if (vinputan1.getText().toString().equals("")) {
                        vinputan1.setError("Masukkan Inputan!");
                    } else {
                        JariJari = Double.valueOf(vinputan1.getText().toString());
                        Volume = 4 * (3.14 * JariJari * JariJari * JariJari) / 3;
                        hasil.setText(Volume.toString());
                    }}
                else if ("Balok".equals(corespin.getSelectedItem().toString())) {
                    if (vinputan1.getText().toString().equals("") || vinputan2.getText().toString().equals("") || vinputan3.getText().toString().equals("")) {
                        if (vinputan1.getText().toString().equals("")) {
                            vinputan1.setError("Masukkan Inputan!");
                        }
                        if (vinputan2.getText().toString().equals("")) {
                            vinputan2.setError("Masukkan Inputan!");
                        }
                        if (vinputan3.getText().toString().equals("")) {
                            vinputan3.setError("Masukkan Inputan!");
                        }
                    } else {
                        Panjang = Double.valueOf(vinputan1.getText().toString());
                        Lebar = Double.valueOf(vinputan2.getText().toString());
                        Tinggi = Double.valueOf(vinputan3.getText().toString());
                        Volume = Panjang * Lebar * Tinggi;
                        hasil.setText(Volume.toString());
                    }
                } else {
                    corespin.getSelectedItem().toString();
                    if (vinputan1.getText().toString().equals("") || vinputan2.getText().toString().equals("")) {
                        if (vinputan1.getText().toString().equals("")) {
                            vinputan1.setError("Masukkan Inputan!");
                        }
                        if (vinputan2.getText().toString().equals("")) {
                            vinputan2.setError("Masukkan Inputan!");
                        }
                    } else {
                        JariJari = Double.valueOf(vinputan1.getText().toString());
                        Tinggi = Double.valueOf(vinputan2.getText().toString());
                        Volume = 3.14 * JariJari * JariJari * Tinggi / 3;
                        hasil.setText(Volume.toString());
                    }
                }
                {

                    }





                    }
                });

    }
}