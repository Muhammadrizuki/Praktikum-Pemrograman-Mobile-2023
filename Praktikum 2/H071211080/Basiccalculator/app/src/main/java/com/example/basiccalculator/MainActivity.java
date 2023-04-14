package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView solution, result;
    MaterialButton buttonC, buttonPersen, buttonpangkat, buttondivide, buttonkali, buttonkurang,
            buttontambah, buttonsamadengan, buttonakar, buttonac;
    String currentNumber = "", currentNumber2;
    boolean a = false;

    float num1, num2, etresult;
    int operator = 0;
    MaterialButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button21);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttontambah = findViewById(R.id.buttonta);
        buttonkurang = findViewById(R.id.buttonku);
        buttonkali = findViewById(R.id.buttonk);
        buttondivide = findViewById(R.id.buttonD);
        buttonsamadengan = findViewById(R.id.buttonsa);
        buttonpangkat = findViewById(R.id.buttonP);
        buttonPersen = findViewById(R.id.button2);
        buttonakar = findViewById(R.id.buttonak);
        buttonC = findViewById(R.id.buttonC);
        result = findViewById(R.id.result);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
// Set OnClickListener for the other buttons
        buttontambah.setOnClickListener(this);
        buttonkurang.setOnClickListener(this);
        buttonkali.setOnClickListener(this);
        buttondivide.setOnClickListener(this);
        buttonsamadengan.setOnClickListener(this);
        buttonPersen.setOnClickListener(this);
        buttonpangkat.setOnClickListener(this);
        buttonC.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                currentNumber += "0";
                result.setText(currentNumber);
                break;
            case R.id.button1:
                currentNumber += "1";
                if(a==true) {
                    currentNumber2 += "1";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                break;

            case R.id.button21:
                currentNumber += "2";
                if(a==true) {
                    currentNumber2 += "2";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                result.setText(currentNumber);
                break;

            case R.id.button3:
                currentNumber += "3";
                if(a==true) {
                    currentNumber2 += "3";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                result.setText(currentNumber);
                break;

            case R.id.button4:
                currentNumber += "4";
                if(a==true) {
                    currentNumber2 += "4";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                result.setText(currentNumber);
                break;

            case R.id.button5:
                currentNumber += "5";
                if(a==true) {
                    currentNumber2 += "5";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                result.setText(currentNumber);
                break;

            case R.id.button6:
                currentNumber += "6";
                if(a==true) {
                    currentNumber2 += "6";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                result.setText(currentNumber);
                break;

            case R.id.button7:
                currentNumber += "7";
                if(a==true) {
                    currentNumber2 += "7";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                result.setText(currentNumber);
                break;

            case R.id.button8:
                currentNumber += "8";
                if(a==true) {
                    currentNumber2 += "8";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                result.setText(currentNumber);
                break;

            case R.id.button9:
                currentNumber += "9";
                if(a==true) {
                    currentNumber2 += "9";
                    result.setText(currentNumber2);
                }else{
                    result.setText(currentNumber);
                }
                result.setText(currentNumber);
                break;

            // Add more cases for the other number buttons
            case R.id.buttonta:
                num1 = Float.parseFloat(currentNumber);
                operator = 1;
                currentNumber2 = operatorSymbol(operator);
                result.setText(currentNumber2);
                currentNumber="";
                a = true;
                break;
            case R.id.buttonku:
                num1 = Float.parseFloat(currentNumber);
                operator = 2;
                currentNumber2 = operatorSymbol(operator);
                result.setText(currentNumber2);
                currentNumber = "";
                a = true;
                break;
            case R.id.buttonk:
                num1 = Float.parseFloat(currentNumber);
                operator = 3;
                currentNumber2 = operatorSymbol(operator);
                result.setText(currentNumber2);
                currentNumber = "";
                a = true;
                break;
            case R.id.buttonD:
                num1 = Float.parseFloat(currentNumber);
                operator = 4;
                currentNumber2 = operatorSymbol(operator);
                result.setText(currentNumber2);
                currentNumber = "";
                a = true;
                break;

            case R.id.button2:
                num1 = Float.parseFloat(currentNumber);
                operator = 5;
                currentNumber2 = operatorSymbol(operator);
                result.setText(currentNumber2);
                currentNumber = "";
                a = true;
                break;

            case R.id.buttonP:
                num1 = Float.parseFloat(currentNumber);
                operator = 6;
                currentNumber2 = operatorSymbol(operator);
                result.setText(currentNumber2);
                currentNumber = "";
                a = true;
                break;
            case R.id.buttonak:
                num1 = Float.parseFloat(currentNumber);
                operator = 6;
                currentNumber2 = operatorSymbol(operator);
                result.setText(currentNumber2);
                a = false;
                break;
            case R.id.buttonsa:
                num2 = Float.parseFloat(currentNumber);
                switch (operator) {
                    case 1:
                        etresult = num1 + num2;
                        break;
                    case 2:
                        etresult = num1 - num2;
                        break;
                    case 3:
                        etresult = num1 * num2;
                        break;
                    case 4:
                        etresult = num1 / num2;
                        break;
                    case 5:
                        etresult = num1 % num2;
                        break;
                    case 6:
                        etresult = (float) Math.pow(num1,num2);
                        break;
                    case 7:
                        etresult = (float) Math.sqrt(num1);
                        break;
                    default:
                        break;
                }
                result.setText(String.valueOf(etresult));
                solution.setText(String.format("%s %s %s = %s", num1, operatorSymbol(operator), num2, etresult));
                currentNumber = "=";
                break;
            case R.id.buttonC:
                currentNumber2 = "";
                currentNumber = "";
                result.setText("");
                solution.setText("");
                break;

            case R.id.buttonac:
                if(currentNumber.length()>0) {
                    currentNumber2 = currentNumber.substring(0, currentNumber.length() - 1);
                    result.setText(currentNumber2);
                }
                break;


        }
    }

    private String operatorSymbol(int operator) {
        String symbol = "";
        switch (operator) {
            case 1:
                symbol = "+";
                break;
            case 2:
                symbol = "-";
                break;
            case 3:
                symbol = "*";
                break;
            case 4:
                symbol = "/";
                break;
            case 5:
                symbol = "%";
                break;
            case 6:
                symbol = "^";
                break;
            case 7:
                symbol = "√";
                break;
        }
        return symbol;
    }
    }


