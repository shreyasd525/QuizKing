package com.example.shreyas.quizking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FinishActivity extends AppCompatActivity {
    private TextView scoreTV2;
    private Button LogET;
    private String rollNo,score1;
    private int score;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        scoreTV2=(TextView) findViewById(R.id.scoreTV2);
        LogET =(Button) findViewById(R.id.LogET);

        firebaseAuth =FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("completed");

        Bundle bundle = getIntent().getExtras();
        final String rollNo = bundle.getString("Roll No1");
        Intent mIntent = getIntent();
        final int score = mIntent.getIntExtra("score",0);
        score1 = String.valueOf(score);


        scoreTV2.setText("Your Score :"+score);

        LogET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                String id =databaseReference.push().getKey();
                Info info =new Info(rollNo,score1);
                databaseReference.child(id).setValue(info);

                Intent intent = new Intent(FinishActivity.this,MainPageActivity.class);
                startActivity(intent);
            }
        });
    }
}
