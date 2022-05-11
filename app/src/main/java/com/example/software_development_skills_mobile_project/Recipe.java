package com.example.software_development_skills_mobile_project;

public class Recipe implements java.io.Serializable {

    private int weekNumber;
    private String name;
    private String serving;
    private String foodstuffs;

    public Recipe(String n, String s, String f) {
        name = n;
        serving = s;
        foodstuffs = f;
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

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }
}
