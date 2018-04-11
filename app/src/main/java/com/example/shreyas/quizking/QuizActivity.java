package com.example.shreyas.quizking;

/**
 * Created by Shreyas on 11-04-2018.
 */

public class QuizActivity {
    String question, answerA, answerB, answerC, answerD, correct;
    public int qId;

    public QuizActivity(int qkey, String question, String answerA, String answerB, String answerC, String answerD, String correct) {
        this.qId = qkey;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct = correct;
    }

    public int getqId() {
        return (qId);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }
}
