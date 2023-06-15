package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    private TextView tv_output, tv_input;
    boolean hasOpration = false;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_clear,
                    btn_tambah, btn_kurang, btn_bagi, btn_hapus, btn_kali, btn_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_clear = findViewById(R.id.btn_clear);
        btn_tambah =findViewById(R.id.btn_tambah);
        btn_kurang = findViewById(R.id.btn_kurang);
        btn_bagi = findViewById(R.id.btn_bagi);
        btn_kali = findViewById(R.id.btn_kali);
        btn_hapus = findViewById(R.id.btn_hapus);
        btn_hasil = findViewById(R.id.btn_hasil);
        tv_output = findViewById(R.id.tv_output);
        tv_input = findViewById(R.id.tv_input);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasOpration = false;
                tv_output.setText("");
                tv_input.setText("");
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("0");
                }else {
                    tv_input.setText(proses + "0");
                }
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("1");
                }else {
                    tv_input.setText(proses + "1");
                }
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("2");
                }else {
                    tv_input.setText(proses + "2");
                }
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("3");
                }else {
                    tv_input.setText(proses + "3");
                }
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("4");
                }else {
                    tv_input.setText(proses + "4");
                }
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("5");
                }else {
                    tv_input.setText(proses + "5");
                }
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("6");
                }else {
                    tv_input.setText(proses + "6");
                }
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("7");
                }else {
                    tv_input.setText(proses + "7");
                }
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("8");
                }else {
                    tv_input.setText(proses + "8");
                }
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                String hasil = tv_output.getText().toString();
                if (proses == hasil){
                    tv_input.setText("9");
                }else {
                    tv_input.setText(proses + "9");
                }
            }
        });

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(hasOpration) return;
                String proses = tv_input.getText().toString();
                char a = proses.charAt(proses.length()-1);
                if (a == '×' || a == '÷' || a == '+' || a == '-'){
                    proses = proses.substring(0, proses.length()-1);
                }
                tv_input.setText(proses + "+");
                hasOpration = true;
            }
        });

        btn_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasOpration) return;
                String proses = tv_input.getText().toString();
                char a = proses.charAt(proses.length()-1);
                if (a == '×' || a == '÷' || a == '+' || a == '-'){
                    proses = proses.substring(0, proses.length()-1);
                }
                tv_input.setText(proses + "-");
                hasOpration = true;
            }
        });

        btn_kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasOpration) return;
                String proses = tv_input.getText().toString();
                char a = proses.charAt(proses.length()-1);
                if (a == '×' || a == '÷' || a == '+' || a == '-'){
                    proses = proses.substring(0, proses.length()-1);
                }
                tv_input.setText(proses + "×");
                hasOpration = true;
            }
        });

        btn_bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasOpration) return;
                String proses = tv_input.getText().toString();
                char a = proses.charAt(proses.length()-1);
                if (a == '×' || a == '÷' || a == '+' || a == '-'){
                    proses = proses.substring(0, proses.length()-1);
                }
                tv_input.setText(proses + "÷");
                hasOpration = true;
            }
        });

        btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proses = tv_input.getText().toString();
                int input = proses.length();
                if(input > 0){
                    char a = proses.charAt(input-1);
                    if ((a == '×' || a == '÷' || a == '+' || a == '-')){
                        hasOpration = false;
                    }
                    tv_input.setText(proses.substring(0, input - 1));
                }
            }
        });

        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hasil = tv_input.getText().toString();

                hasil = hasil.replaceAll("×", "*");
                hasil = hasil.replaceAll("÷", "/");
                hasil = hasil.replaceAll("-", "-");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
//              Kode tersebut digunakan untuk membuat objek konteks Rhino yang baru dan menentukan tingkat optimasi untuk konteks tersebut.

                try{
                    Scriptable scriptable = rhino.initSafeStandardObjects();
//                  Baris ini membuat sebuah objek Scriptable dengan menginisialisasi standar objek-objek JavaScript yang aman dengan menggunakan fungsi initSafeStandardObjects() dari objek rhino. Objek Scriptable akan digunakan sebagai lingkungan eksekusi dari kode JavaScript.
                    finalResult = rhino.evaluateString(scriptable,hasil, "javascript", 1, null).toString();
//                  Baris ini mengevaluasi sebuah string yang berisi kode JavaScript yang disimpan pada variabel hasil menggunakan fungsi evaluateString() dari objek rhino. Hasil evaluasi tersebut akan diubah ke dalam bentuk string dan disimpan pada variabel finalResult.
                }catch (Exception e) {
                    finalResult = "0";
//                  Baris ini adalah bagian dari blok try yang akan menangani sebuah exception yang mungkin terjadi selama proses evaluasi kode JavaScript. Jika terjadi exception, variabel finalResult akan diset ke nilai "0".
                }
                tv_output.setText(finalResult);
                tv_input.setText(finalResult);
            }
        });
    }
}