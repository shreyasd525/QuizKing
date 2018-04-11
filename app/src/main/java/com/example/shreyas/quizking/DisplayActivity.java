package com.example.shreyas.quizking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplayActivity extends AppCompatActivity {
    private Button ViewET,AddQET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        AddQET =(Button) findViewById(R.id.AddQET);
        ViewET =(Button) findViewById(R.id.ViewET);

        AddQET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this,TeacherActivity.class);
                startActivity(intent);
            }
        });

        ViewET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this,ViewActivity.class);
                startActivity(intent);

            }
        });
    }
}
