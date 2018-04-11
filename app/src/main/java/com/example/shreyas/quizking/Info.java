package com.example.shreyas.quizking;

/**
 * Created by Shreyas on 11-04-2018.
 */

public class Info {
    String rollNo,score;


    public Info(String rollNo, String score) {
        this.rollNo = rollNo;
        this.score = score;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
