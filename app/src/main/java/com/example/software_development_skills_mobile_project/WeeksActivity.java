package com.example.software_development_skills_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class WeeksActivity extends AppCompatActivity {

    ListView listView;
    int weekNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeks);
        listView = (ListView) findViewById(R.id.weeksListView);
    }

    public void addWeekFoods() {
    }
}