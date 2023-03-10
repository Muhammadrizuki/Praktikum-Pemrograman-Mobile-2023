package com.example.assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KeduaFragment extends Fragment {
    private EditText et_jari, et_tinggi;
    private Button btn_hitung;
    private TextView tv_hasil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kedua, container, false);
        et_jari = v.findViewById(R.id.et_jari);
        et_tinggi = v.findViewById(R.id.et_tinggi);
        btn_hitung = v.findViewById(R.id.btn_hitung);
        tv_hasil = v.findViewById(R.id.tv_hasil);

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai1 = et_jari.getText().toString();
                String nilai2 = et_tinggi.getText().toString();

                if (nilai1.isEmpty()){
                    et_jari.setError("Data tidak boleh kosong");
                    et_jari.requestFocus();
                } else if (nilai2.isEmpty()) {
                    et_tinggi.setError("Data tidak boleh kosong");
                    et_tinggi.requestFocus();
                } else {
                    Integer jari = Integer.parseInt(nilai1);
                    Integer tinggi = Integer.parseInt(nilai2);

                    Integer volume = jari*tinggi;
                    tv_hasil.setText(String.valueOf(volume));
                }
            }
        });
        return v;
    }
}