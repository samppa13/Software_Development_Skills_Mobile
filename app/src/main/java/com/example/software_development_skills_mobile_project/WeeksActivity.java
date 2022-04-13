package com.example.software_development_skills_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class WeeksActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeks);
        listView = (ListView) findViewById(R.id.weeksListView);
        WeekAdapter weekAdapter = new WeekAdapter(this);
        listView.setAdapter(weekAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showRecipeActivity = new Intent(getApplicationContext(), RecipeActivity.class);
                showRecipeActivity.putExtra("com.example.ITEM.INDEX", i);
                startActivity(showRecipeActivity);
            }
        });
    }
}