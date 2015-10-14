/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.util.ArrayList;

/**
 *
 * @author saumil
 */
public class RecipeBean {
    
    private String name;
    private String meal[];
    private ArrayList mealList;
    private String diet;
    private String cusine;
    private String people;
    private String calories;
    private String time;
    private String ingredients[];
    private ArrayList ingredientsList;
    private String steps;
    private String image;
    private String userId;
    private String recipeId;
    
    public void setRecipeId(String recipeId){
        this.recipeId = recipeId;
    }
    public String getRecipeId(){
        return recipeId;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return userId;
    }
    
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return image;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setMeal(String meal[]){
        this.meal = meal;
    }
    public String[] getMeal(){
        return meal;
    }
    
    public void setMealList(ArrayList mealList){
        this.mealList = mealList;
    }
    public ArrayList getMealList(){
        return mealList;
    }
    
    public void setDiet(String diet){
        this.diet = diet;
    }
    public String getDiet(){
        return diet;
    }
    
    public void setCusine(String cusine){
        this.cusine = cusine;
    }
    public String getCusine(){
        return cusine;
    }
    
    public void setPeople(String people){
        this.people = people;
    }
    public String getPeople(){
        return people;
    }
    
    public void setCalories(String calories){
        this.calories = calories;
    }
    public String getCalories(){
        return calories;
    }
    
    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return time;
    }
    
    public void setIngredients(String ingredients[]){
        this.ingredients = ingredients;
    }
    public String[] getIngredients(){
        return ingredients;
    }
    
    public void setIngredientsList(ArrayList ingredientsList){
        this.ingredientsList = ingredientsList;
    }
    public ArrayList getIngredientsList(){
        return ingredientsList;
    }
    
    public void setSteps(String steps){
        this.steps = steps;
    }
    public String getSteps(){
        return steps;
    }
    
}
