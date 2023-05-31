package com.example.tugasprak2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView jari,tinggi,panjang,lebar,hasil ;
    EditText p,t,j,l;
    Button hitung;

    String [] list={"Bola", "Kerucut", "Balok"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.sp);
        jari=findViewById(R.id.text1);
        tinggi=findViewById(R.id.text2);
        panjang=findViewById(R.id.text3);
        lebar=findViewById(R.id.text4);
        p=findViewById(R.id.edit3);
        t=findViewById(R.id.edit2);
        j=findViewById(R.id.edit1);
        l=findViewById(R.id.edit4);
        hitung=findViewById(R.id.hitung);
        hasil=findViewById(R.id.hasil);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString().equals(list[0])) {
                    if (j.getText().toString().isEmpty()) {
                        jari.setError("Field ini tidak boleh kosong");
                    } else {
                        Double jarijari = Double.valueOf(j.getText().toString());
                        Double volumeBola = (4.00 / 3.00) * Math.PI * Math.pow(jarijari, 3);
                        String duaFormat = String.format("%.2f", volumeBola);
                        hasil.setText(duaFormat);
                    }
                }else if (spinner.getSelectedItem().toString().equals(list[1])) {
                        if (j.getText().toString().isEmpty() && t.getText().toString().isEmpty()){
                            j.setError("Field ini tidak boleh kosong");
                            t.setError("Field ini tidak boleh kosong");
                        } else if (j.getText().toString().isEmpty()) {
                            j.setError("Field ini tidak boleh kosong");
                        } else if (t.getText().toString().isEmpty()) {
                            t.setError("Field ini tidak boleh kosong");
                        }else {
                            Double jarijari = Double.valueOf(j.getText().toString());
                            Double tinggi = Double.valueOf(t.getText().toString());
                            Double volumeKerucut = (Math.PI * Math.pow(jarijari, 2) * tinggi) / 3.00;
                            String duaFormat = String.format("%.2f", volumeKerucut);
                            hasil.setText(duaFormat);
                        }
    } else if (spinner.getSelectedItem().toString().equals(list[2])) {
        if (p.getText().toString().isEmpty() && l.getText().toString().isEmpty() && t.getText().toString().isEmpty()) {
            p.setError("Field ini tidak boleh kosong");
            l.setError("Field ini tidak boleh kosong");
            t.setError("Field ini tidak boleh kosong");
        } else if (p.getText().toString().isEmpty() && l.getText().toString().isEmpty()) {
            p.setError("Field ini tidak boleh kosong");
            l.setError("Field ini tidak boleh kosong");
        } else if (p.getText().toString().isEmpty() && t.getText().toString().isEmpty()) {
            p.setError("Field ini tidak boleh kosong");
            t.setError("Field ini tidak boleh kosong");
        } else if (l.getText().toString().isEmpty() && t.getText().toString().isEmpty()) {
            l.setError("Field ini tidak boleh kosong");
            t.setError("Field ini tidak boleh kosong");
        } else if (p.getText().toString().isEmpty()) {
            p.setError("Field ini tidak boleh kosong");
        } else if (l.getText().toString().isEmpty()) {
            l.setError("Field ini tidak boleh kosong");
        } else if (t.getText().toString().isEmpty()) {
            t.setError("Field ini tidak boleh kosong");
        } else {
            Double panjang = Double.valueOf(p.getText().toString());
            Double lebar = Double.valueOf(l.getText().toString());
            Double tinggi = Double.valueOf(t.getText().toString());
            Double volumeBalok = (panjang * lebar * tinggi);
            String duaFormat = String.format("%.2f", volumeBalok);
            hasil.setText(duaFormat);
        }
    }
}
});
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
@Override
public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (position){
        case 0:
        jari.setVisibility(View.VISIBLE);
        j.setVisibility(View.VISIBLE);
        panjang.setVisibility(View.GONE);
        p.setVisibility(View.GONE);
        lebar.setVisibility(View.GONE);
        l.setVisibility(View.GONE);
        tinggi.setVisibility(View.GONE);
        t.setVisibility(View.GONE);
        break;
        case 1:
        jari.setVisibility(View.VISIBLE);
        j.setVisibility(View.VISIBLE);
        panjang.setVisibility(View.GONE);
        p.setVisibility(View.GONE);
        lebar.setVisibility(View.GONE);
        l.setVisibility(View.GONE);
        tinggi.setVisibility(View.VISIBLE);
        t.setVisibility(View.VISIBLE);
        break;
        case 2:
        jari.setVisibility(View.GONE);
        j.setVisibility(View.GONE);
        panjang.setVisibility(View.VISIBLE);
        p.setVisibility(View.VISIBLE);
        lebar.setVisibility(View.VISIBLE);
        l.setVisibility(View.VISIBLE);
        tinggi.setVisibility(View.VISIBLE);
        t.setVisibility(View.VISIBLE);
        break;
        }
}

@Override
public void onNothingSelected(AdapterView<?> adapterView) {

           }
      });
    }
}
