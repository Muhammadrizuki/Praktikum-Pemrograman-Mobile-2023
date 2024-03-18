package com.example.tuagslab31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    Button optionA, optionB, optionC, optionD;
    TextView questions, judul;
    String Question[] = {
            "1. Ayam apa yang makan sambal?",
            "2. Bebek apa yang suka berdansa?",
            "3. Ikan apa yang tertawa ketika hujan?",
            "4. Beruang yang hidup dineraka?",
            "5. Musang yang biasa diperjual belikan di facebook?"
    };
    String Answer[][] = {
            {"Ayam Jones", "Ayam Betina", "Ayamm mo saja", "Ayam Tapioka"},
            {"Bebek Angsa", "Bebek Betina", "Bebek  mo saja", "Bebek kan mi"},
            {"Ikan Mujair", "Ikan 1945", "Ikan Tupai", "Ikan Bontang"},
            {"Beruang Brunei", "Beruang Kutub", "Beruang Manado", "Beruang McD"},
            {"Musang mo saja", "Musang Kenalpot", "Musang Andalag", "Musang Twitter"}
    };
    String Correct[] = {
            "Ayam Jones",
            "Bebek Angsa",
            "Ikan Mujair",
            "Beruang Manado",
            "Musang Andalang"
    };
    Photo photo;
    int number = 0;
    int score = 0;
    int bScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        questions = findViewById(R.id.pertanyaan);
        judul = findViewById(R.id.judul);

        showQuiz(number);
        bScore = getIntent().getIntExtra("BEST SCORE",0);
        photo = getIntent().getParcelableExtra("PROFIL");

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showQuiz(number);
                checkAnswer(number - 1, 0);
            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showQuiz(number);
                checkAnswer(number - 1, 1);
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showQuiz(number);
                checkAnswer(number - 1, 2);
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                showQuiz(number);
                checkAnswer(number - 1, 3);
            }
        });

    }

    private void showQuiz(int number) {
        if (number == Question.length) {
            toDetailScore();
            return;
        }

        int QuestionNumber = number + 1;
        String judulQuiz = "Question " + QuestionNumber + " of 5";
        judul.setText(judulQuiz);
        questions.setText(Question[number]);
        optionA.setText(Answer[number][0]);
        optionB.setText(Answer[number][1]);
        optionC.setText(Answer[number][2]);
        optionD.setText(Answer[number][3]);
    }
// untuk mengecek jawaban
    private void checkAnswer(int number, int pilihan) {
        if (number == Question.length) {
            toDetailScore();
            return;
        }
        String urAnswer = Answer[number][pilihan];
        String CorrectAnswer = Correct[number];
        if (urAnswer.equalsIgnoreCase(CorrectAnswer)) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            score += 100;
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }
    }
// untuk pindah ke activity detail score
    private void toDetailScore() {
        Intent intent = getIntent();
        String Name = getIntent().getStringExtra("FULL NAME");
        if (score >= bScore) {
            bScore = score;
        }

        Intent KeDetailScore = new Intent(Quiz.this, Detail_Score.class);
        KeDetailScore.putExtra("SCORE", score);
        KeDetailScore.putExtra("BEST SCORE", bScore);
        KeDetailScore.putExtra("FULL NAME", Name);
        KeDetailScore.putExtra("PROFIL", photo);
        startActivity(KeDetailScore);
        finish();
    }

}