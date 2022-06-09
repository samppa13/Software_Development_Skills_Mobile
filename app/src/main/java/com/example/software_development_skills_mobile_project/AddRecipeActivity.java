package com.example.software_development_skills_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AddRecipeActivity extends AppCompatActivity {

    Recipes recipes = Recipes.getInstance();
    EditText nameEditText;
    EditText foodstuffEditText;
    SeekBar servingSeekBar;
    TextView seekBarTextView;
    Spinner weekNumberSpinner;
    Button saveButton;
    Button cancelButton;
    String weekNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecipe);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        foodstuffEditText = (EditText) findViewById(R.id.foodstuffEditText);
        servingSeekBar = (SeekBar) findViewById(R.id.servingSeekBar);
        seekBarTextView = (TextView) findViewById(R.id.seekBarTextView);
        servingSeekBar.setMax(6);
        servingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarTextView.setText(String.valueOf(servingSeekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        weekNumberSpinner = (Spinner) findViewById(R.id.weekNumberSpinner);
        ArrayAdapter<String> weekNumberAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.weekNumbers));
        weekNumberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weekNumberSpinner.setAdapter(weekNumberAdapter);
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        weekNumberSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                weekNumber = (String) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String serving = String.valueOf(servingSeekBar.getProgress());
                servingSeekBar.setProgress(0);
                String foodstuff = foodstuffEditText.getText().toString();
                recipes.addRecipe(name, serving, foodstuff, weekNumber);
                Intent showMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(showMainActivity);
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(showMainActivity);
            }
        });
    }
}