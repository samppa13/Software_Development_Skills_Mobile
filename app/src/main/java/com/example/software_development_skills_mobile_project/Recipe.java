package com.example.software_development_skills_mobile_project;

public class Recipe implements java.io.Serializable {

    private String name;
    private String serving;
    private String foodstuffs;
    private String  weekNumber;

    public Recipe(String n, String s, String f, String  w) {
        setName(n);
        setServing(s);
        setFoodstuffs(f);
        setWeekNumber(w);
    }

    public String getName() {
        return name;
    }

    public String getServing() {
        return serving;
    }

    public String getFoodstuffs() {
        return foodstuffs;
    }

    public String getWeekNumber() {
        return weekNumber;
    }

    public void setName(String n) { name = n; }

    public void setServing(String s) {
        serving = s;
    }

    public void setFoodstuffs(String f) {
        foodstuffs = f;
    }

    public void setWeekNumber(String  w) {
        weekNumber = w;
    }

}
