package com.example.shreyas.quizking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    private Button StartET;
    private TextView RollNoET;
    String rollNo,rollNo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        StartET =findViewById(R.id.StartET);
        RollNoET=findViewById(R.id.RollNoET);


        StartET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollNo = RollNoET.getText().toString().trim();
                rollNo1 =RollNoET.getText().toString();
                Log.d("valueofroll", "value = " + rollNo1);
                if (!TextUtils.isEmpty(rollNo)){
                    Intent intent = new Intent(StartActivity.this, StudentActivity.class);
                    intent.putExtra("Roll No",rollNo1);
                    StartActivity.this.startActivity(intent);

                } else {
                    Toast.makeText(StartActivity.this, "Enter roll No", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }



}
