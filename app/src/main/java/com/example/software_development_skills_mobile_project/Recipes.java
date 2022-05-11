package com.example.software_development_skills_mobile_project;

import android.content.Context;

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

    private Context context;

    private Recipes() {
        loadRecipes(this.context);
    }

    public void addContext(Context context) {
        this.context = context;
    }

    public static Recipes getInstance() {
        return recipes;
    }

    public void addRecipe(String name, String serving, String foodstuffs) {
        recipeArrayList.add(new Recipe(name, serving, foodstuffs));
        saveRecipes(this.context);
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

    private void saveRecipes(Context context) {
        String fileName = "recipes.json";
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(this);
            os.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRecipes(Context context) {
        String fileName = "recipes.json";
        try {
            FileInputStream fis = context.openFileInput(fileName);
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
