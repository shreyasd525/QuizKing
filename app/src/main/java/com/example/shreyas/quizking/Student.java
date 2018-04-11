package com.example.shreyas.quizking;

/**
 * Created by Shreyas on 11-04-2018.
 */

public class Student {
    String id,email;

    public Student(String id,String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
