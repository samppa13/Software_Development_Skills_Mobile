package com.example.software_development_skills_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    Recipes recipes = Recipes.getInstance();
    TextView nameTextView;
    TextView servingTextView;
    TextView foodstuffTextView;
    TextView weekNumberTextView;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Intent intent = getIntent();
        id = intent.getIntExtra("com.example.ITEM.INDEX", -1);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        servingTextView = (TextView) findViewById(R.id.servingTextView);
        foodstuffTextView = (TextView) findViewById(R.id.foodstuffsTextView);
        weekNumberTextView = (TextView) findViewById(R.id.weekNumberTextView);
        nameTextView.setText(recipes.getRecipeName(id));
        String serving = recipes.getRecipeServing(id) + " serving";
        if(Integer.parseInt(recipes.getRecipeServing(id)) > 1){serving += "s";}
        servingTextView.setText(serving);
        foodstuffTextView.setText(recipes.getRecipeFoodstuffs(id));
        weekNumberTextView.setText(recipes.getRecipeWeekNumber(id));
    }
}