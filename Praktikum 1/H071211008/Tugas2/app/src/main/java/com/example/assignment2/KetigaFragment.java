package com.example.assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.badge.BadgeUtils;

public class KetigaFragment extends Fragment {
    private EditText et_panjang, et_lebar, et_tinggi;
    private Button btn_hitung;
    private TextView tv_hasil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ketiga, container, false);
        et_panjang = v.findViewById(R.id.et_panjang);
        et_lebar = v.findViewById(R.id.et_lebar);
        et_tinggi = v.findViewById(R.id.et_tinggi);
        btn_hitung = v.findViewById(R.id.btn_hitung);
        tv_hasil = v.findViewById(R.id.tv_hasil);

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai1 = et_panjang.getText().toString();
                String nilai2 = et_lebar.getText().toString();
                String nilai3 = et_tinggi.getText().toString();

                if (nilai1.isEmpty()){
                    et_panjang.setError("Data tidak boleh kosong");
                    et_panjang.requestFocus();
                } else if (nilai2.isEmpty()) {
                    et_lebar.setError("Data tidak boleh kosong");
                    et_lebar.requestFocus();
                } else if (nilai3.isEmpty()) {
                    et_tinggi.setError("Data tidak boleh kosong");
                    et_tinggi.requestFocus();
                }else {
                    Integer panjang = Integer.parseInt(nilai1);
                    Integer lebar = Integer.parseInt(nilai2);
                    Integer tinggi = Integer.parseInt(nilai2);

                    Integer volume = panjang*lebar*tinggi;
                    tv_hasil.setText(String.valueOf(volume));
                }
            }
        });
        return v;
    }
}