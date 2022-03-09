package com.example.androidexercisetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class ExerciseMenu extends AppCompatActivity {
    FrameLayout runningButton;
    FrameLayout bikingButton;
    FrameLayout rowingButton;
    FrameLayout freeWeightsButton;
    FrameLayout stairClimbingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_menu);

        runningButton = findViewById(R.id.runningButton);
        bikingButton = findViewById(R.id.runningButton);
        rowingButton = findViewById(R.id.runningButton);
        freeWeightsButton = findViewById(R.id.runningButton);
        stairClimbingButton = findViewById(R.id.runningButton);

        runningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExerciseMenu.this, RunningActivity.class));
            }
        });

//        bikingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchToRecordPage();
//            }
//        });
//
//        stairClimbingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchToRecordPage();
//            }
//        });
//
//        freeWeightsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchToRecordPage();
//            }
//        });
//
//        rowingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchToRecordPage();
//            }
//        });

    }

    //change to switch page on click
    private void switchToRecordPage() {
        //test purposes. delete this:
        Toast successToast = Toast.makeText(this,  "Button pushed", Toast.LENGTH_SHORT);
        successToast.show();

    }
}