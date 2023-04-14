package com.sisfo.tugaspraktikum5.model;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;

import com.sisfo.tugaspraktikum5.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {

    public Button[] choiceButton;
    private String question;
    private String[] choices;
    private int answerIndex, score;
    private List<Quiz> quizList;
    public Resources app;

    public Quiz(String question, String[] choices, int answerIndex, int score) {
        this.question = question;
        this.choices = choices;
        this.answerIndex = answerIndex;
        this.score = score;
    }

    public Quiz(Button... choiceButtons) {
        for (int i = 0; i < choiceButtons.length; i++) {
            choiceButtons[i].setTag(i);
        }
        this.choiceButton = choiceButtons;
    }

    public List<Quiz> getQuiz() {
        quizList = new ArrayList<>();

        quizList.add(new Quiz(app.getString(R.string.q1), app.getStringArray(R.array.c1), 1, 24));
        quizList.add(new Quiz(app.getString(R.string.q2), app.getStringArray(R.array.c2), 0, 24));
        quizList.add(new Quiz(app.getString(R.string.q3), app.getStringArray(R.array.c3), 0, 35));
        quizList.add(new Quiz(app.getString(R.string.q4), app.getStringArray(R.array.c4), 2, 28));
        quizList.add(new Quiz(app.getString(R.string.q5), app.getStringArray(R.array.c5), 3, 42));
        quizList.add(new Quiz(app.getString(R.string.q6), app.getStringArray(R.array.c6), 0, 32));
        quizList.add(new Quiz(app.getString(R.string.q7), app.getStringArray(R.array.c7), 2, 45));
        quizList.add(new Quiz(app.getString(R.string.q8), app.getStringArray(R.array.c8), 3, 43));
        quizList.add(new Quiz(app.getString(R.string.q9), app.getStringArray(R.array.c9), 1, 32));
        quizList.add(new Quiz(app.getString(R.string.q10), app.getStringArray(R.array.c10), 2, 31));

        Collections.shuffle(quizList);
        return quizList.subList(0, 5);
    }

    public void  setContext(Context context) {
        this.app = context.getResources();
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public int getScore() {
        return score;
    }
}
