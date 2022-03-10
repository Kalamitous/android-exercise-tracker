package com.example.androidexercisetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        getSupportActionBar().setTitle("Exercise Tracker");
    }

    public void onRecordActivity(View v) {
        startActivity(new Intent(MainMenu.this, ExerciseMenu.class));
    }

    public void onBodyDetails(View v) {
        startActivity(new Intent(MainMenu.this, BodyDetails.class));
    }
}
