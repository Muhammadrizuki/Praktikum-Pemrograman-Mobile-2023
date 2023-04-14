package com.example.bangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;

    private Spinner spinner;
    private EditText editText2;

    private TextView result;

    private TextView result1;
    private Button button2;
    private EditText editText3;

    private EditText editText4;

    private EditText editText6;

    private EditText editText7;

    private EditText editText8;

    private Button button1;

    private Button button3;

    private TextView result2;

    private EditText editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        editText1 = findViewById(R.id.Edittext1);
        editText2 = findViewById(R.id.Edittext2);
        editText3 = findViewById(R.id.Edittext3);
        editText4 = findViewById(R.id.Edittext4);
        editText5 = findViewById(R.id.Edittext5);
        editText6 = findViewById(R.id.Edittext6);
        editText7 = findViewById(R.id.Edittext7);
        editText8 = findViewById(R.id.Edittext8);
        button1 = findViewById(R.id.Buttonkubus);
        button2 = findViewById(R.id.Buttonbalok);
        button3 = findViewById(R.id.Buttonlimas);
        result = findViewById(R.id.Result);
        result1 = findViewById(R.id.Result1);
        result2 = findViewById(R.id.Result2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Kubus")) {
                    editText1.setVisibility(View.GONE);
                    editText2.setVisibility(View.GONE);
                    editText3.setVisibility(View.GONE);
                    editText4.setVisibility(View.VISIBLE);
                    editText5.setVisibility(View.VISIBLE);
                    editText6.setVisibility(View.GONE);
                    editText7.setVisibility(View.GONE);
                    editText8.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    result2.setVisibility(View.GONE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.GONE);
                    result.setVisibility(View.VISIBLE);
                    result1.setVisibility(View.GONE);
                } else if(selectedItem.equals("Balok")){
                    editText1.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                    editText3.setVisibility(View.VISIBLE);
                    editText4.setVisibility(View.GONE);
                    editText5.setVisibility(View.GONE);
                    editText6.setVisibility(View.GONE);
                    editText7.setVisibility(View.GONE);
                    editText8.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    result2.setVisibility(View.GONE);
                    button1.setVisibility(View.GONE);
                    button2.setVisibility(View.VISIBLE);
                    result.setVisibility(View.GONE);
                    result1.setVisibility(View.VISIBLE);
                }else if(selectedItem.equals("Limas segitiga")){
                    editText1.setVisibility(View.GONE);
                    editText2.setVisibility(View.GONE);
                    editText3.setVisibility(View.GONE);
                    editText4.setVisibility(View.GONE);
                    editText5.setVisibility(View.GONE);
                    editText6.setVisibility(View.VISIBLE);
                    editText7.setVisibility(View.VISIBLE);
                    editText8.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    button3.setVisibility(View.VISIBLE);
                    result.setVisibility(View.GONE);
                    result1.setVisibility(View.GONE);
                    result2.setVisibility(View.VISIBLE);
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText sisi1 = findViewById(R.id.Edittext4);
                EditText sisi4 = findViewById(R.id.Edittext5);
                TextView hasil = findViewById(R.id.Result);

                String sisiSTR1 = sisi1.getText().toString();
                String sisiSTR2 = sisi4.getText().toString();

                if (TextUtils.isEmpty(sisiSTR1)) {
                    sisi1.setError("sisi tidak boleh kosong");
                    return;
                }

                if (TextUtils.isEmpty(sisiSTR2)) {
                    sisi4.setError("sisi tidak boleh kosong");
                    return;
                }

                double sisi2 = Double.parseDouble(sisiSTR1);
                double sisi3= Double.parseDouble(sisiSTR2);
                double volume = sisi2 * sisi3;
                hasil.setText("Volume kubus = " + volume);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText panjang1 = findViewById(R.id.Edittext1);
                EditText lebar1 = findViewById(R.id.Edittext2);
                EditText tinggi1 = findViewById(R.id.Edittext3);
                TextView hasil1 = findViewById(R.id.Result1);

                String panjangStr = panjang1.getText().toString();
                String lebarStr = lebar1.getText().toString();
                String tinggiStr = tinggi1.getText().toString();

                if (TextUtils.isEmpty(panjangStr)) {
                    panjang1.setError("Panjang tidak boleh kosong");
                    return;
                }

                if (TextUtils.isEmpty(lebarStr)) {
                    lebar1.setError("Lebar tidak boleh kosong");
                    return;
                }

                if (TextUtils.isEmpty(tinggiStr)) {
                    tinggi1.setError("Tinggi tidak boleh kosong");
                    return;
                }

                double panjang2 = Double.parseDouble(panjangStr);
                double lebar2 = Double.parseDouble(lebarStr);
                double tinggi2 = Double.parseDouble(tinggiStr);
                double volume = panjang2 * lebar2 * tinggi2;
                hasil1.setText("Volume balok =" + volume);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText alas1 = findViewById(R.id.Edittext6);
                EditText tinggi1 = findViewById(R.id.Edittext7);
                EditText tinggi2 = findViewById(R.id.Edittext8);
                TextView hasil2 = findViewById(R.id.Result2);

                String alasStr = alas1.getText().toString();
                String tinggiStr1 = tinggi1.getText().toString();
                String tinggiStr2 = tinggi2.getText().toString();

                if (TextUtils.isEmpty(alasStr)) {
                    alas1.setError("Alas tidak boleh kosong");
                    return;
                }

                if (TextUtils.isEmpty(tinggiStr1)) {
                    tinggi1.setError("tinggi tidak boleh kosong");
                    return;
                }

                if (TextUtils.isEmpty(tinggiStr2)) {
                    tinggi2.setError("Tinggi tidak boleh kosong");
                    return;
                }

                double alas2 = Double.parseDouble(alasStr);
                double tinggi3 = Double.parseDouble(tinggiStr1);
                double tinggi4 = Double.parseDouble(tinggiStr2);
                double volume = alas2 * tinggi3 * tinggi4;
                hasil2.setText("Volume limas =" + volume);
            }
        });


    }
}

