package com.example.androidexercisetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExerciseMenu extends AppCompatActivity {
    Button runningButton;
    Button bikingButton;
    Button rowingButton;
    Button freeWeightsButton;
    Button stairClimbingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_menu);

        runningButton = (Button) findViewById(R.id.runningButton);
        bikingButton = (Button) findViewById(R.id.bikingButton);
        rowingButton = (Button) findViewById(R.id.rowingButton);
        freeWeightsButton = (Button) findViewById(R.id.freeWeightsButton);
        stairClimbingButton = (Button) findViewById(R.id.stairClimbingButton);

        runningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExerciseMenu.this, MainActivity.class));
            }
        });

        bikingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToRecordPage();
            }
        });

        stairClimbingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToRecordPage();
            }
        });

        freeWeightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToRecordPage();
            }
        });

        rowingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToRecordPage();
            }
        });

    }

    //change to switch page on click
    private void switchToRecordPage() {
        //test purposes. delete this:
        Toast successToast = Toast.makeText(this,  "Button pushed", Toast.LENGTH_SHORT);
        successToast.show();

    }
}