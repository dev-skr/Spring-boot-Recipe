// Write your code here
package com.example.recipe;

import java.util.*;

public class Recipe{
    private int recipeId;
    private String recipeName;
    private String recipeType;
    private List<String> ingredients;

    Recipe(int id,String name,String type,List<String> list){
        this.recipeId=id;
        this.recipeName=name;
        this.recipeType=type;
        this.ingredients=list;
    }

public void setRecipeId(int id){
    this.recipeId=id;
}

public int getRecipeId(){
    return recipeId;
}

public void setRecipeName(String name){
    this.recipeName=name;
}

public String getRecipeName(){
    return recipeName;
}

public void setRecipeType(String type){
    this.recipeType=type;
}

public String getRecipeType(){
    return recipeType;
}

public void setIngredients(List<String> ings){
    this.ingredients=ings;
}

public List<String> getIngredients(){
    return ingredients;
}
}