package com.sisfo.tugaspraktikum5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sisfo.tugaspraktikum5.model.Player;
import com.sisfo.tugaspraktikum5.model.Quiz;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView question, questionLevel;
    private Quiz q;
    private List<Quiz> quiz;
    private int score = 0, qIndex = 0;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        player = getIntent().getParcelableExtra("player");

        q = new Quiz(findViewById(R.id.choice1), findViewById(R.id.choice2), findViewById(R.id.choice3), findViewById(R.id.choice4));
        q.setContext(this);
        quiz = q.getQuiz();
        question = findViewById(R.id.question_text);
        questionLevel = findViewById(R.id.question_level);
        q.choiceButton[0].setOnClickListener(this::choiceOnClick);
        q.choiceButton[1].setOnClickListener(this::choiceOnClick);
        q.choiceButton[2].setOnClickListener(this::choiceOnClick);
        q.choiceButton[3].setOnClickListener(this::choiceOnClick);

        renderQuestion();
    }

    private void choiceOnClick(View choice) {
        int answerIndex = (int) choice.getTag();
        int correctAnswer = quiz.get(qIndex).getAnswerIndex();

        if (correctAnswer == answerIndex) {
            choice.setBackgroundColor(Color.GREEN);
            score += quiz.get(qIndex).getScore();

        } else choice.setBackgroundColor(Color.RED);

        for (int i = 0; i < 4; i++)
            q.choiceButton[i].setEnabled(false);

        choice.postDelayed(() -> {
            choice.setBackgroundColor(Color.parseColor("#3F51B5"));
            choice.setEnabled(true);
            qIndex++;

            renderQuestion();
        }, 1250);

    }

    @SuppressLint("DefaultLocale")
    private void renderQuestion() {
        if (qIndex == quiz.size()) {
            Intent intent = new Intent(this, ScoreActivity.class);
            System.out.println(score + "pts");
            player.setScore(score);
            intent.putExtra("player", player);
            startActivity(intent);
            finish();
            return;

        } else {
            questionLevel.setText(String.format("Question %d", (qIndex + 1)));
            question.setText(quiz.get(qIndex).getQuestion());
        }

        for (int i = 0; i < 4; i++) {
            String choice = quiz.get(qIndex).getChoices()[i];
            q.choiceButton[i].setText(choice);
            q.choiceButton[i].setEnabled(true);
        }
    }
}