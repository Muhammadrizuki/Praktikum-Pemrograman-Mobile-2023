package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView questionText;

    private Button optiona, optionb, optionc, optiond, optione, nextbutton;

    private int indexquestion = 0;

    private String[] question = {
            "Siapa penjahat di jujutsu kaisen?",
            "Siapa pemeran Utama Hell Paradise?",
            "Siapa yang menang piala dunia 2022?",
            "Siapa pacar takemichi?",
            "Siapa adek mikey?"
    };

    private String[][] option = {
            {"Kenjaku", "Pande", "Mei", "Itadori", "Yuta"},
            {"Gamibaru", "Madara", "Sasuke", "Orochimaru", "Muslih"},
            {"Perancis", "Argentina", "Rusia", "Filipina", "Indonesia"},
            {"Hina", "Mei", "Hinata", "Yuna", "Yuki"},
            {"Emma", "Echa", "Edward", "Izana", "Baji"}
    };

    private int[] answer = {0, 0, 1, 0, 0};

    private long startTime;

    private String st1,st2;

    private Bundle bundle;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        questionText = findViewById(R.id.textview);
        optiona = findViewById(R.id.option1);
        optionb = findViewById(R.id.optiona);
        optionc = findViewById(R.id.optionb);
        optiond = findViewById(R.id.optionc);
        optione = findViewById(R.id.optiond);
        nextbutton = findViewById(R.id.nextbutton);

        st1 = getIntent().getExtras().getString("text1");
        st2 = getIntent().getExtras().getString("text2");
        bundle = getIntent().getExtras().getBundle("image");


        displayquestion();

        optiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optiona);
            }
        });

        optionb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optionb);
            }
        });

        optionc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optionc);
            }
        });

        optiond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optiond);
            }
        });

        optione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(optione);
            }
        });

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (optiona.isEnabled() && optionb.isEnabled() && optionc.isEnabled() && optiond.isEnabled() && optione.isEnabled()) {
                    Toast.makeText(MainActivity.this, "Pilih jawaban dulu", Toast.LENGTH_SHORT).show();
                } else {
                    indexquestion++;

                    displayquestion();
                }
            }
        });

    }

    private void checkAnswer(Button selectedButton) {
        int correctAnswerIndex = answer[indexquestion];
        int selectedAnswerIndex = -1;
        switch (selectedButton.getId()) {
            case R.id.option1:
                selectedAnswerIndex = 0;
                break;
            case R.id.optiona:
                selectedAnswerIndex = 1;
                break;
            case R.id.optionb:
                selectedAnswerIndex = 2;
                break;
            case R.id.optionc:
                selectedAnswerIndex = 3;
                break;
            case R.id.optiond:
                selectedAnswerIndex = 4;
                break;
        }
        if (selectedAnswerIndex == correctAnswerIndex) {
            Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();

            ScoreActivity.correctAnswers++;
        } else {
            Toast.makeText(this, "Salah", Toast.LENGTH_SHORT).show();
        }
        // Disable all buttons
        optiona.setEnabled(false);
        optionb.setEnabled(false);
        optionc.setEnabled(false);
        optiond.setEnabled(false);
        optione.setEnabled(false);





    }





    private void displayquestion() {

        if(indexquestion<question.length){
             questionText.setText(question[indexquestion]);
             optiona.setText(option[indexquestion][0]);
             optionb.setText(option[indexquestion][1]);
             optionc.setText(option[indexquestion][2]);
             optiond.setText(option[indexquestion][3]);
             optione.setText(option[indexquestion][4]);

            optiona.setEnabled(true);
            optionb.setEnabled(true);
            optionc.setEnabled(true);
            optiond.setEnabled(true);
            optione.setEnabled(true);
        }else{


            int correctAnswers = ScoreActivity.correctAnswers;
            double finalScore = correctAnswers * 100;

            int score = (int) finalScore;
            Intent intent = new Intent(MainActivity.this,ScoreActivity.class);

            intent.putExtra("text1",st1);
            intent.putExtra("text2",st2);
            intent.putExtra("image",bundle);

            intent.putExtra("Score",score);

            startActivity(intent);
        }
    }
}
