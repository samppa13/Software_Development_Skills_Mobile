package com.example.software_development_skills_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddRecipeActivity extends AppCompatActivity {

    Recipes recipes = Recipes.getInstance();
    EditText nameEditText;
    EditText servingEditText;
    EditText foodstuffEditText;
    Spinner weekNumberSpinner;
    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecipe);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        servingEditText = (EditText) findViewById(R.id.servingEditText);
        foodstuffEditText = (EditText) findViewById(R.id.foodstuffEditText);
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String serving = servingEditText.getText().toString();
                String foodstuff = foodstuffEditText.getText().toString();
                recipes.addRecipe(name, serving, foodstuff, "zfdyudyrgxfhcyufdt");
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