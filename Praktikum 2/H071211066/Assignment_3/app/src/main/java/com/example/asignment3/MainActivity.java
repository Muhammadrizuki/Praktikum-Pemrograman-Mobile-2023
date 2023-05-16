package com.example.asignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button bagi, kali, kurang, tambah, sama_dengan;
    TextView proses, hasil_;
    String proses_dan_hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bagi = findViewById(R.id.bagi);
        kali = findViewById(R.id.kali);
        kurang = findViewById(R.id.kurang);
        tambah = findViewById(R.id.tambah);
        sama_dengan = findViewById(R.id.sama_dengan);

        proses = findViewById(R.id.proses);
        hasil_ = findViewById(R.id.hasil);
    }

    public void bagi(View view) {
        proses_dan_hasil = proses.getText().toString();
        proses.setText(proses_dan_hasil + "/");
        bagi.setEnabled(false);
        kali.setEnabled(false);
        tambah.setEnabled(false);
        kurang.setEnabled(false);
        sama_dengan.setEnabled(false);
    }

    public void tujuh(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        sama_dengan.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")) {
            proses.setText("7");
        } else {
            proses.setText(proses_dan_hasil + "7");
        }
    }

    public void delapan(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        sama_dengan.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("8");
        } else {
            proses.setText(proses_dan_hasil + "8");
        }
    }
    public void sembilan(View view) {
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        sama_dengan.setEnabled(true);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("9");
        } else {
            proses.setText(proses_dan_hasil + "9");
        }
    }

    public void kali(View view) {
        proses_dan_hasil = proses.getText().toString();
        proses.setText(proses_dan_hasil + "x");
        bagi.setEnabled(false);
        kali.setEnabled(false);
        tambah.setEnabled(false);
        kurang.setEnabled(false);
        sama_dengan.setEnabled(false);
    }

    public void empat(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        sama_dengan.setEnabled(true);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("4");
        } else {
            proses.setText(proses_dan_hasil + "4");
        }
    }
    public void lima(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        sama_dengan.setEnabled(true);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("5");
        } else {
            proses.setText(proses_dan_hasil + "5");
        }
    }

    public void enam(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        sama_dengan.setEnabled(true);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("6");
        } else {
            proses.setText(proses_dan_hasil + "6");
        }
    }

    public void kurang(View view) {
        proses_dan_hasil = proses.getText().toString();
        proses.setText(proses_dan_hasil + "-");
        bagi.setEnabled(false);
        kali.setEnabled(false);
        tambah.setEnabled(false);
        kurang.setEnabled(false);
        sama_dengan.setEnabled(false);
    }

    public void satu(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        sama_dengan.setEnabled(true);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("1");
        } else {
            proses.setText(proses_dan_hasil + "1");
        }
    }

    public void dua(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        sama_dengan.setEnabled(true);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("2");
        } else {
            proses.setText(proses_dan_hasil + "2");
        }
    }

    public void tiga(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        sama_dengan.setEnabled(true);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("3");
        } else {
            proses.setText(proses_dan_hasil + "3");
        }
    }

    public void tambah(View view) {
        proses_dan_hasil = proses.getText().toString();
        proses.setText(proses_dan_hasil + "+");
        bagi.setEnabled(false);
        kali.setEnabled(false);
        tambah.setEnabled(false);
        kurang.setEnabled(false);
        sama_dengan.setEnabled(false);
    }

    public void nol(View view) {
        bagi.setEnabled(true);
        kali.setEnabled(true);
        tambah.setEnabled(true);
        kurang.setEnabled(true);
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        sama_dengan.setEnabled(true);
        proses_dan_hasil = proses.getText().toString();
        if (proses_dan_hasil.equals("0")){
            proses.setText("0");
        } else {
            proses.setText(proses_dan_hasil + "0");
        }
    }

    public void delete(View view) {

        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);

        String delete = proses.getText().toString();
        int length = delete.length();
        if (length == 1) {
            proses.setText("0");
        } else {
            proses.setText(delete.substring(0, length-1));
            bagi.setEnabled(true);
            kali.setEnabled(true);
            tambah.setEnabled(true);
            kurang.setEnabled(true);
        }
    }

    public void clear(View view) {
        hasil_.setVisibility(View.GONE);
        proses.setVisibility(View.VISIBLE);
        proses.setText("0");
        sama_dengan.setEnabled(true);
    }

    public void sama_dengan(View view) {
        proses_dan_hasil = proses.getText().toString();


        proses_dan_hasil = proses_dan_hasil.replaceAll("x", "*");
        proses_dan_hasil = proses_dan_hasil.replaceAll("/", "/");

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);

        String hasil = "";

        try {
            Scriptable scriptable = rhino.initSafeStandardObjects();
            hasil = rhino.evaluateString(scriptable, proses_dan_hasil, "javascript", 0, null).toString();
        } catch (Exception e){
            hasil="0";
        }

        bagi.setEnabled(false);
        kali.setEnabled(false);
        tambah.setEnabled(false);
        kurang.setEnabled(false);
        sama_dengan.setEnabled(false);

        hasil_.setVisibility(View.VISIBLE);
        proses.setText("0");
        proses.setVisibility(View.GONE);
        hasil_.setText(hasil);
    }
}