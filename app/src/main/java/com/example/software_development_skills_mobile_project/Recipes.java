package com.example.software_development_skills_mobile_project;

import java.util.ArrayList;

public class Recipes {

    private static Recipes recipes = new Recipes();
    ArrayList<Recipe> recipeArrayList = new ArrayList();

    private Recipes() {}

    public static Recipes getInstance() {
        return recipes;
    }

    public void addRecipe(String name, String serving, String foodstuffs) {
        recipeArrayList.add(new Recipe(name, serving, foodstuffs));
    }

    public String getRecipeName(int id) {
        return recipeArrayList.get(id).getName();
    }

    public String getRecipeServing(int id) {
        return recipeArrayList.get(id).getServing();
    }

    public String getRecipeFoodstuffs(int id) {
        return recipeArrayList.get(id).getFoodstuffs();
    }
}
