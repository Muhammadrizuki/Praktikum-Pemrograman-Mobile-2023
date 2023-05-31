package com.example.tugas3_nomor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private int currentIndex = 0, userScore = 0;
    private List<QuestionAnswer> QuestionAnswersList;
    public static final String EXTRA_PLAYER = "extra_player";

    private TextView[] answers;
    private  TextView  question, noQuest, answerA, answerB, answerC, answerD;

    private  View[] viewAnswers;
    private  View view1,view2, view3, view4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        question = findViewById(R.id.question);
        noQuest = findViewById(R.id.no_quest);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3  = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        answerA = findViewById(R.id.textAnswer1);
        answerB = findViewById(R.id.textAnswer2);
        answerC = findViewById(R.id.textAnswer3);
        answerD = findViewById(R.id.textAnswer4);


        QuestionAnswersList = QuestionAnswer.getAllQuestion();

        answers = new TextView[] {answerA,answerB,answerC,answerD};
        viewAnswers = new View[] {view1,view2,view3,view4};

        renderQuestion();
        answers[0].setOnClickListener(view -> onAnswerClicked(0));
        answers[1].setOnClickListener(view -> onAnswerClicked(1));
        answers[2].setOnClickListener(view -> onAnswerClicked(2));
        answers[3].setOnClickListener(view -> onAnswerClicked(3));
    }
    private  void  renderQuestion(){
//        Log.e("tes",String.valueOf(currentIndex));
        QuestionAnswer QuestionAnswers = QuestionAnswersList.get(currentIndex);
        noQuest.setText(String.format("Quiz %d of 5",currentIndex +1));
        question.setText(QuestionAnswers.getQuestion());
        for (int i = 0; i < answers.length; i++){
            answers[i].setText(QuestionAnswers.getAnswer()[i]);
        }
    }
    public void  onAnswerClicked (int index) {
        QuestionAnswer QuestionAnswer = QuestionAnswersList.get(currentIndex);
        boolean isTrue = index == QuestionAnswer.getCorrectAnswer();

        userScore += isTrue ? QuestionAnswer.getScore() : 0;
        viewAnswers[index].setBackground(isTrue ? getDrawable(R.drawable.hijau_background): getDrawable(R.drawable.merah_background));

        new Handler().postDelayed(()-> {
            if (currentIndex == 4){
                Player player = getIntent().getParcelableExtra(EXTRA_PLAYER);
                Intent intent = new Intent(this,MainActivity3.class);
                intent.putExtra(MainActivity3.EXTRA_SCORE, userScore);
                intent.putExtra(EXTRA_PLAYER, player);
                startActivity(intent);
            }else {
                viewAnswers[index].setBackground(getDrawable(R.drawable.tampilan_answer));
                currentIndex++;
                renderQuestion();
            }
        }, 2000);
    }

}