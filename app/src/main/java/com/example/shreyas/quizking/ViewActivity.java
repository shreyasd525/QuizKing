package com.example.shreyas.quizking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class ViewActivity extends AppCompatActivity {
    private TextView ScoreTV3,RollTV;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        RollTV = findViewById(R.id.RollTV);
        ScoreTV3 = findViewById(R.id.ScoreTV3);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("completed");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
                        collectAllData((Map<String,Object>) dataSnapshot.getValue());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }
    private void collectAllData(Map<String,Object> users) {

        ArrayList<String> arrayList = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            arrayList.add((String)singleUser.get("rollNo"));
            arrayList.add((String)singleUser.get("score"));

        }
        //ScoreTV3.setText(arrayList.toString());
        //System.out.println(arrayList.toString());


    }
}
