package com.example.software_development_skills_mobile_project;

import java.util.ArrayList;

public class WeekFoods {

    private static WeekFoods weekFoods = new WeekFoods();
    Recipes recipes = Recipes.getInstance();
    private int index;
    private int weekNumber;
    ArrayList<Recipe> weekFoodsArrayList = new ArrayList();

    private WeekFoods() {
    }

    public static WeekFoods getInstance() {
        return weekFoods;
    }

    public void addWeek(int id) {
        weekFoodsArrayList.add(recipes.getRecipe(index));
        weekFoodsArrayList.get(id).setWeekNumber(weekNumber);
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

    public int getWeekNumber(int id) {
        return weekFoodsArrayList.get(id).getWeekNumber();
    }
}
