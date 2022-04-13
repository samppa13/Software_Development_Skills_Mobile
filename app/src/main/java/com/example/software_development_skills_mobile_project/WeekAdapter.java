package com.example.software_development_skills_mobile_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WeekAdapter extends BaseAdapter {

    WeekFoods weekFoods = WeekFoods.getInstance();
    LayoutInflater inflater;

    public WeekAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return weekFoods.weekFoodsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return weekFoods.getRecipeName(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = inflater.inflate(R.layout.week_listview_detail, null);
        TextView weekNumberTextView = (TextView) view1.findViewById(R.id.weekNumberTextView);
        TextView recipe1TextView = (TextView) view1.findViewById(R.id.recipe1TextView);
        TextView recipe2TextView = (TextView) view1.findViewById(R.id.recipe2TextView);
        TextView recipe3TextView = (TextView) view1.findViewById(R.id.recipe3TextView);
        String weekNumber = String.valueOf(weekFoods.getWeekNumber(i)) + " Week";
        String recipe1 = weekFoods.getRecipeName(i);
        String recipe2 = weekFoods.getRecipeName(i);
        String recipe3 = weekFoods.getRecipeName(i);
        weekNumberTextView.setText(weekNumber);
        recipe1TextView.setText(recipe1);
        recipe2TextView.setText(recipe2);
        recipe3TextView.setText(recipe3);
        return view1;
    }
}
