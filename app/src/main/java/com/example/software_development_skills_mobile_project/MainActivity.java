package com.example.software_development_skills_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Recipes recipes = Recipes.getInstance();
    Button cookbookButton;
    Button newRecipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recipes.addContext(this);
        cookbookButton = (Button) findViewById(R.id.cookbookButton);
        newRecipeButton = (Button) findViewById(R.id.newRecipeButton);
        cookbookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showCookbookActivity = new Intent(getApplicationContext(), CookbookActivity.class);
                startActivity(showCookbookActivity);
            }
        });
        newRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showAddRecipeActivity = new Intent(getApplicationContext(), AddRecipeActivity.class);
                startActivity(showAddRecipeActivity);
            }
        });
    }
}