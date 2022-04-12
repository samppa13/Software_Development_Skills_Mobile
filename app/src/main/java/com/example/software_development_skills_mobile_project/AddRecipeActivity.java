package com.example.software_development_skills_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRecipeActivity extends AppCompatActivity {

    Recipes recipes = Recipes.getInstance();
    EditText nameEditText;
    EditText servingEditText;
    EditText foodstuffEditText;
    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecipe);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        servingEditText = (EditText) findViewById(R.id.servingEditText);
        foodstuffEditText = (EditText) findViewById(R.id.foodstuffEditText);
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String serving = servingEditText.getText().toString();
                String foodstuff = foodstuffEditText.getText().toString();
                recipes.addRecipe(name, serving, foodstuff);
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