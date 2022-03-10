package com.example.androidexercisetracker;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Optional;

public class BodyDetails extends AppCompatActivity {
    EditText nameInput;
    EditText weightInput;
    EditText heightInput;
    EditText ageInput;
   // User newUser;
    Button applyChangesButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Body Details");

        applyChangesButton = (Button) findViewById(R.id.applyBtn);

        nameInput = findViewById(R.id.weightInputTxt);
        weightInput = findViewById(R.id.heightInputTxt);
        heightInput = findViewById(R.id.genderInputTxt3);
        ageInput = findViewById(R.id.genderInputTxt);


        //Set fields to user's current information on page load
        setName();
        setWeight();
        setHeight();
        setAge();


        //User details


        applyChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                applyChanges();

            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onApplyChanges(View v) {
        //startActivity(new Intent(BodyDetails.this, MainMenu.class));
    }

    public void applyChanges() {
        //Name
        nameInput = findViewById(R.id.weightInputTxt);
        String strNewName = nameInput.getText().toString();

        if (!strNewName.matches("")) {
            User.updateName(java.util.Optional.of(strNewName));
            setName();

        }


        //Weight
        weightInput = findViewById(R.id.heightInputTxt);
        String strNewWeight = weightInput.getText().toString();

        if (!strNewWeight.matches("")) {
            int intNewWeight = Integer.parseInt(strNewWeight);
            User.updateWeight(java.util.Optional.of(intNewWeight));

            setWeight();

        }

        //Height
        heightInput = findViewById(R.id.genderInputTxt3);
        String strNewHeight = heightInput.getText().toString();

        if (!strNewHeight.matches("")) {
            int intNewHeight = Integer.parseInt(strNewHeight);
            User.updateHeight(java.util.Optional.of(intNewHeight));
            setHeight();

        }



        //Age
        ageInput = findViewById(R.id.genderInputTxt);
        String strNewAge = ageInput.getText().toString();

        if (!strNewAge.matches("")) {
            int intNewAge = Integer.parseInt(strNewAge);
            User.updateAge(java.util.Optional.of(intNewAge));

            setAge();

        }


        Toast success = Toast.makeText(this,  "Body details successfully updated", Toast.LENGTH_SHORT);
        success.show();

    }

    public void setWeight() {
        if (User.weight.isPresent()) {
            weightInput.setText(String.valueOf(User.weight.get()));
        }
    }

    public void setHeight() {
        if (User.height.isPresent()) {
            heightInput.setText(String.valueOf(User.height.get()));
        }
    }

    public void setName() {
        if (User.name.isPresent()) {
            nameInput.setText(User.name.get());
        }
    }

    public void setAge() {
        if (User.age.isPresent()) {
            ageInput.setText(String.valueOf(User.age.get()));
        }
    }

}
