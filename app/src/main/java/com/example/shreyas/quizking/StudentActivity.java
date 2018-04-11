package com.example.shreyas.quizking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentActivity extends AppCompatActivity {
    private TextView ScoreTV, QuestionTV;
    private Button AnswerA,AnswerB,AnswerC,AnswerD;
    private int score =0;
    private int questionNo=100;
    int maxQ;
    private String answer;
    private DatabaseReference questionRef,answerARef,answerBRef,answerCRef,answerDRef,correctRef,databaseReference;
    public int total,clickcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        ScoreTV = findViewById(R.id.ScoreTV);
        QuestionTV = findViewById(R.id.QuestionTV);
        AnswerA =  findViewById(R.id.AnswerA);
        AnswerB =  findViewById(R.id.AnswerB);
        AnswerC =  findViewById(R.id.AnswerC);
        AnswerD =  findViewById(R.id.AnswerD);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference= database.getReference("questions");

//You can use the single or the value.. depending if you want to keep track
        this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                total= (int) dataSnapshot.getChildrenCount();
                Toast.makeText(StudentActivity.this, "Total ="+total, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        updateQuestions();

        AnswerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AnswerA.getText().equals(answer)){
                    score=score+1;
                    updateScore(score);
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
                clickcount++;
                isLastQuestion(total,clickcount,score);
            }
        });

        AnswerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AnswerB.getText().equals(answer)){
                    score=score+1;
                    updateScore(score);
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
                clickcount++;
                isLastQuestion(total,clickcount,score);
            }
        });

        AnswerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AnswerC.getText().equals(answer)){
                    score=score+1;
                    updateScore(score);
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
                clickcount++;
                isLastQuestion(total,clickcount,score);
            }
        });

        AnswerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AnswerD.getText().equals(answer)){
                    score=score+1;
                    updateScore(score);
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
                clickcount++;
                isLastQuestion(total,clickcount,score);
            }
        });

    }

    void updateQuestions(){
        questionRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://quiz-king-6f6b2.firebaseio.com/questions/"+questionNo+"/question");

        questionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question =dataSnapshot.getValue(String.class);
                QuestionTV.setText(question);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        answerARef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://quiz-king-6f6b2.firebaseio.com/questions/"+questionNo+"/answerA");
        answerARef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                AnswerA.setText(choice);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        answerBRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://quiz-king-6f6b2.firebaseio.com/questions/"+questionNo+"/answerB");
        answerBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                AnswerB.setText(choice);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        answerCRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://quiz-king-6f6b2.firebaseio.com//questions/"+questionNo+"/answerC");
        answerCRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                AnswerC.setText(choice);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        answerDRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://quiz-king-6f6b2.firebaseio.com/questions/"+questionNo+"/answerD");
        answerDRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                AnswerD.setText(choice);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        correctRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://quiz-king-6f6b2.firebaseio.com/questions/"+questionNo+"/correct");
        correctRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                answer =dataSnapshot.getValue(String.class);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        questionNo++;


    }

    private void updateScore(int score){
        ScoreTV.setText("score :"+String.format("%d",score));
    }

    private void isLastQuestion(int total,int clickcount,int score){
        if(total == clickcount) {
            Bundle bundle = getIntent().getExtras();
            String rollNo = bundle.getString("Roll No");
            Intent intent = new Intent(StudentActivity.this,FinishActivity.class);
            intent.putExtra("score",score);
            intent.putExtra("Roll No1",rollNo);
            startActivity(intent);

        }
    }
}
