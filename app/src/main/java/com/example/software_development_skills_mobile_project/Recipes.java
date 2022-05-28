package com.example.software_development_skills_mobile_project;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Recipes {

    private static Recipes recipes = new Recipes();
    ArrayList<Recipe> recipeArrayList = new ArrayList<>();

    private Recipes() {
        loadRecipes();
    }

    public static Recipes getInstance() {
        return recipes;
    }

    public void addRecipe(String name, String serving, String foodstuffs, String weekNumber) {
        recipeArrayList.add(new Recipe(name, serving, foodstuffs, weekNumber));
        saveRecipes();
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

    public Recipe getRecipe(int id) {
        return recipeArrayList.get(id);
    }

    public void saveRecipes() {
        String fileName = "recipes.json";
        try {
            FileOutputStream fos = GlobalApplication.getContext().openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(recipeArrayList);
            os.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRecipes() {
        String fileName = "recipes.json";

        // Check if file doesn't exist
        File file = GlobalApplication.getContext().getFileStreamPath(fileName);
        if(!file.exists()) {
            saveRecipes();
        }

        try {
            FileInputStream fis = GlobalApplication.getContext().openFileInput(fileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            recipeArrayList = (ArrayList<Recipe>) is.readObject();
            is.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
