package com.sisfo.tugaspraktikum3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    String current = "0";
    BigDecimal total;
    Boolean onOperation = false, processed = false;
    EditText process;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        process = findViewById(R.id.process);
        result = findViewById(R.id.result);
        result.setVisibility(View.GONE);
    }

    public void cumulate(View button) {
        append(((Button) button).getText().toString());
        onOperation = false;
    }

    public void interact(View button) {
        current = process.getText().toString();
        if (current.equals("0")) return;

        switch (button.getId()) {
            case R.id.clearBtn:
                clearAll();
                break;
            case R.id.backspaceBtn:
                this.afterMath(processed, "×");
                char last = current.charAt(current.length() - 1);
                System.out.println(last);
                onOperation = false;

                if (current.length() > 1) {
                    process.setText(current.substring(0, current.length() - 1));
                    formatNum(process.getText().toString());
                }
                else process.setText("0");
                break;
        }
    }

    public void operator(View button) {
        if (onOperation) return;
        current = process.getText().toString();
        String temp = current;

        if (button.getId() == R.id.calculateBtn) {
            result.setVisibility(View.VISIBLE);
            String[] preCalc = current.split("(?<=[−+×÷])|(?=[−+×÷])");

            for (int i = 0; i < preCalc.length; i++) {
                if (!preCalc[i].matches(".*[−+×÷].*")) {
                    preCalc[i] = preCalc[i].replaceAll("\\.", "");
                }
                System.out.println("Entry : " + preCalc[i]);
            }

            ArrayList<String> calc = new ArrayList<>(Arrays.asList(preCalc));

            for (String x : calc) {
                if (x.equals("×") || x.equals("÷")) {
                    int index = calc.indexOf(x);
                    if (x.equals("×")) {
                        System.out.println(total);
                        System.out.println("X : "+x);
                        total = new BigDecimal(calc.get(index - 1)).multiply(new BigDecimal(calc.get(index + 1))); // 5000, +, 25

                    } else {
                        if (calc.get(index + 1).equals("0")) {
                            result.setText(R.string.divide_zero);
                            return;
                        }
                        total = new BigDecimal(calc.get(index - 1)).divide(new BigDecimal(calc.get(index + 1)), 2, RoundingMode.HALF_UP);
                        System.out.println("Total : " + total);
                    } simulateTreeOn(calc, total, index);
                }
            } calc.removeAll(Arrays.asList("#", null));

            for (String x : calc) {
                if (x.equals("+") || x.equals("−")) {
                    int index = calc.indexOf(x);
                    total = x.equals("+") ? new BigDecimal(calc.get(index - 1)).add(new BigDecimal(calc.get(index + 1))) :
                            new BigDecimal(calc.get(index - 1)).subtract(new BigDecimal(calc.get(index + 1)));

                    simulateTreeOn(calc, total, index);
                }
            } calc.removeAll(Arrays.asList("#", null));

            Formatter opt = new Formatter(new StringBuilder(), Locale.GERMANY); // US Fck
            String finalResult = String.valueOf(opt.format("%,.2f", Double.parseDouble(calc.get(0))));
            finalResult = (finalResult.endsWith(",00")) ? finalResult.substring(0, finalResult.length() - 3) : finalResult;

            result.setText(temp);
            process.setText(finalResult);
            processed = true;

        } else {
            append(((Button) button).getText().toString());
            onOperation = true;
        }
    }

    private void simulateTreeOn(ArrayList<String> items, BigDecimal numbs, int position) {
        items.set(position + 1, String.valueOf(numbs));
        items.set(position - 1, "#");
        items.set(position, "#");
    }

    private void append(String numb) {
        afterMath(processed, numb);
        current = process.getText().toString();

        if (current.length() > 20) return;
        if (processed) result.setText("0");
        System.out.println("Process : " + current);

        if (current.length() == 1 && current.equals("0"))
            process.setText((numb.matches(".*[−+×÷].*")) ? "0" + numb : numb);
        else {
            process.setText(String.format("%s%s", current, numb));
            formatNum(process.getText().toString());
        }
    }

    @SuppressLint("DefaultLocale")
    private void formatNum(String numb) {
        String[] split = numb.split("(?<=[−+×÷])|(?=[−+×÷])");
        String formatted = "";
        for (String x : split) {
            if (!x.matches(".*[−+×÷].*"))
                x = String.format("%,d", Long.parseLong(x.replaceAll("\\.", "")));

            formatted = String.join("", formatted, x);
        }
        process.setText(formatted);
    }

    private void afterMath(Boolean isProcessing, String numb) {
        if (isProcessing) {
            if (!numb.matches(".*[−+×÷].*")) {
                clearAll();
                current += numb;
                return;
            }
            current = result.getText().toString();
            process.setText(current);
            result.setVisibility(View.GONE);
            result.setText("0");
            processed = false;
        }
    }

    private void clearAll() {
        this.process.setText("0");
        this.result.setVisibility(View.GONE);
        onOperation = false;
        processed = false;
    }
}