package com.example.praktikum3t22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private CardView A, B, C, D;
    private TextView questNumber, questSection;
    private Question question1, question2,question3, question4, question5, question6, question7, question8, question9, selectedQuestion;
    private AppCompatButton opsi1, opsi2, opsi3, opsi4;
    private Stack<Question> questions = new Stack<>();
    private int score, questionNumber = 0;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questNumber = findViewById(R.id.questNumber);
        questSection = findViewById(R.id.questSection);
        opsi1 = findViewById(R.id.opsi1);
        opsi2 = findViewById(R.id.opsi2);
        opsi3 = findViewById(R.id.opsi3);
        opsi4 = findViewById(R.id.opsi4);

        user = getIntent().getParcelableExtra("User");

        makeQuestion();
        questions.addAll(Arrays.asList(question1, question2, question3, question4, question5, question6, question7, question8, question9));
        Collections.shuffle(questions);
        selectedQuestion = questions.pop();
        setQuestion(selectedQuestion);

        opsi1.setOnClickListener(v-> { answerChecker(opsi1); });
        opsi2.setOnClickListener(v-> { answerChecker(opsi2); });
        opsi3.setOnClickListener(v-> { answerChecker(opsi3); });
        opsi4.setOnClickListener(v-> { answerChecker(opsi4); });
    }

    public void setQuestion(Question question) {
        questionNumber++;
        if (questionNumber > 5) {
            Intent i = new Intent(this, DisplayScoreActivity.class);
            i.putExtra("score", String.valueOf(score));
            i.putExtra("User", user);
            startActivity(i);
            finish();
        } else {
            questSection.setText(question.getQuestionSection());
            opsi1.setText(question.getOpsi1());
            opsi2.setText(question.getOpsi2());
            opsi3.setText(question.getOpsi3());
            opsi4.setText(question.getOpsi4());
            questNumber.setText(String.valueOf(questionNumber));
        }
    }

    public void answerChecker(AppCompatButton button) {
        String answer = button.getText().toString();
        enableStatus(false);
        if (answer.equals(selectedQuestion.getAnswer())) {
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Trues));

            score += selectedQuestion.getScore();

        } else {
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Falses));

        }
        button.postDelayed(() -> {
            enableStatus(true);
            button.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.white));
            button.setTextColor(ContextCompat.getColorStateList(this, R.color.black));
            selectedQuestion = questions.pop();
            setQuestion(selectedQuestion);
        }, 1500);
    }

    public void enableStatus (Boolean status) {
        opsi1.setEnabled(status);
        opsi2.setEnabled(status);
        opsi3.setEnabled(status);
        opsi4.setEnabled(status);
    }

    public void makeQuestion() {
        question1 = new Question(86, "Berapa banyak kartu dalam satu set kartu remi?", "48 kartu", "52 kartu", "56 kartu", "60 kartu", "52 kartu");
        question2 = new Question(92, "Apa perbedaan antara kartu remi biasa dan kartu remi bridge?", "Kartu remi bridge lebih kecil dan lebih pendek", "Kartu remi biasa lebih kecil dan lebih pendek", "Kartu remi bridge lebih besar dan lebih panjang", "Kartu remi biasa lebih besar dan lebih panjang", "Kartu remi bridge lebih besar dan lebih panjang");
        question3 = new Question(90, "Apa saja jenis simbol pada kartu remi?", "Sekop, hati, keriting, wajik", "Lingkaran, segitiga, persegi, bulat", "Berlian, bintang, bulan, matahari", "Hati, tangan, kaki, kepala", "Sekop, hati, keriting, wajik");
        question4 = new Question(79, "Permainan kartu apa yang menggunakan kartu remi?", "Chess", "Monopoly", "Poker", "Scrabble", "Poker");
        question5 = new Question(85, "Bagaimana cara merawat kartu remi agar tetap awet?", "Jangan melipat atau menekuk kartu, simpan di tempat yang kering dan terlindungi dari sinar matahari langsung", "Lipat atau tekan-tekan kartu agar lebih lentur, simpan di tempat yang lembab agar tidak kering", "Cuci kartu dengan air sabun dan gosok-gosok, keringkan di bawah sinar matahari langsung", "Gunakan tangan yang basah saat memainkan kartu", "Jangan melipat atau menekuk kartu, simpan di tempat yang kering dan terlindungi dari sinar matahari langsung");
        question6 = new Question(78, "Berapa banyak jenis kartu remi yang ada dalam satu suit?", "9", "10", "11", "13", "13");
        question7 = new Question(83, "Apa nama susunan kartu terkuat dalam permainan poker?", "Three of a Kind", "Straight", "Flush", "Royal Flush", "Royal Flush");
        question8 = new Question(88, "Permainan kartu apa yang mengharuskan pemain untuk mengumpulkan kartu sejenis dengan nilai yang sama?", "Bridge", "Poker", "Rummy", "Solitaire", "Rummy");
        question9 = new Question(90, "Apa istilah yang digunakan untuk menggambarkan ketika kedua pemain memiliki kartu dengan nilai yang sama dalam permainan kartu?", "Draw", "Split pot", "Flush", "Full house", "Split pot");
    }
}