package com.example.software_development_skills_mobile_project;

import java.util.ArrayList;

public class WeekFoods {

    Recipes recipes = Recipes.getInstance();
    private int weekNumber;
    private int index;
    ArrayList<Recipe> weekFoodsArrayList = new ArrayList();

    public WeekFoods(int wn) {
        weekNumber = wn;
    }

    public void addFoods() {
        weekFoodsArrayList.add(recipes.getRecipe(index));
    }

    public String getRecipeName(int id) {
        return weekFoodsArrayList.get(id).getName();
    }

    public String getRecipeServing(int id) {
        return weekFoodsArrayList.get(id).getServing();
    }

    public String getRecipeFoodstuff(int id) {
        return weekFoodsArrayList.get(id).getFoodstuffs();
    }
}
