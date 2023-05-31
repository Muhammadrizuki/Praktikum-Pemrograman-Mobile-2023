package com.example.tugas3_nomor2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionAnswer {
    private  String question;
    private  String [] answer;
    private  int score;
    private  int correctAnswer;

    public QuestionAnswer(String question, String[] answer, int score, int correctAnswer){
        this.question = question;
        this.answer = answer;
        this.score = score;
        this.correctAnswer = correctAnswer;
    }
    public String[] getAnswer() {return answer;}

    public String getQuestion() {return question;}

    public int getScore(){
        return score;
    }

    public int getCorrectAnswer() { return correctAnswer;}

    public static List<QuestionAnswer> getAllQuestion() {
        List<QuestionAnswer> Quest = new ArrayList<>();
        Quest.add(new QuestionAnswer(" Siapakah penemu telepon?",
                  new String[] {"Thomas Edison","Alexander Graham Bell","Nikola Tesla","Albert Einstein"},40,1));
        Quest.add(new QuestionAnswer("Apa arti dari kutipan the sky's the limit",
                  new String[] {"Ada batasan untuk sukses","Sukses hanya bisa dicapai jika kita memilki banyak uang","Tidak ada batasan untuk sukses","Sukses hanya bisa dicapai jika kita memilki banyak teman"},20,2));
        Quest.add(new QuestionAnswer("Apa yang dimaksud dengan YOLO ?",
                  new String[] {"You Only Live Once","You Only Love Once","You Only Laugh Once","You Only Learn Once"},30,0));
        Quest.add(new QuestionAnswer("Apa nama kota di Italia yang terkenal dengan Menara Miring?",
                  new String[] {"Florence","Rome","Pisa","Milan"}, 20, 2));
        Quest.add(new QuestionAnswer("Apa nama Sungai terbesar di Indonesia?",
                new String[] {"Citarum","Nil","Kapuas","Musi"}, 20, 2));
        Quest.add(new QuestionAnswer("Apa nama hewan terbesar di dunia?",
                new String[] {"Jerapah","Dinosaurus","Gajah","Paus biru"}, 20, 3));
        Quest.add(new QuestionAnswer("Apa nama benua terbesar di dunia?",
                new String[] {"Asia","Afrika","Amerika utara","Australia"}, 20, 0));
        Quest.add(new QuestionAnswer("Apa nama negara yang dijuluki negara paling bahagia di dunia?",
                new String[] {"Jepang","Switzerland","Finlandia","Turki"}, 30, 2));
        Quest.add(new QuestionAnswer("Siapakah nama orang yang suka mematikan mikrofon orang lain sedang rapat?",
                new String[] {"Puan maharani","Utut Adianto","Adian napitupulu","Almuzammil yusuf"}, 10, 0));
        Quest.add(new QuestionAnswer("Pada anime Naruto, siapakah nama cinta pertama Naruto??",
                new String[] {"Hinata","Fuu","Sakura","Temari"}, 30, 2));

        Collections.shuffle(Quest);
        return  Quest.subList(0,5);
    }
}


