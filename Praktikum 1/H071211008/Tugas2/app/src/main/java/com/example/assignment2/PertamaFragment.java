package com.example.assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PertamaFragment extends Fragment {
    private Button btn_hitung;
    private EditText et_jari;
    private TextView tv_hasil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pertama, container, false);
        btn_hitung = v.findViewById(R.id.btn_hitung);
        et_jari = v.findViewById(R.id.et_jari);
        tv_hasil = v.findViewById(R.id.tv_hasil);

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai = et_jari.getText().toString();

                if (nilai.isEmpty()){
                    et_jari.setError("Data tidak boleh kosong");
                    et_jari.requestFocus();
                }else {
                    Integer jari = Integer.parseInt(nilai);

                    Integer volume = jari+jari;
                    tv_hasil.setText(String.valueOf(volume));
                }
            }
        });
        return v;
    }
}