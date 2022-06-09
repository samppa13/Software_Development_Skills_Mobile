package com.example.software_development_skills_mobile_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeAdapter extends BaseAdapter {

    Recipes recipes = Recipes.getInstance();
    LayoutInflater inflater;

    public RecipeAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return recipes.recipeArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return recipes.getRecipeName(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = inflater.inflate(R.layout.recipes_listview_detail, null);
        TextView recipeTextView = (TextView) view1.findViewById(R.id.recipeTextView);
        TextView servingTextView = (TextView) view1.findViewById(R.id.servingTextView);
        String recipe = recipes.getRecipeName(i);
        String serving = recipes.getRecipeServing(i) + " serving";
        if(Integer.parseInt(recipes.getRecipeServing(i)) > 1){serving += "s";}
        recipeTextView.setText(recipe);
        servingTextView.setText(serving);
        return view1;
    }
}
