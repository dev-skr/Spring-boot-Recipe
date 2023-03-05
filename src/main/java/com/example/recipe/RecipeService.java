package com.example.recipe;

import com.example.recipe.RecipeRepository;
import com.example.recipe.Recipe;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();

        public RecipeService() {
                recipeBook.put(1,
                                new Recipe(1, "Pasta", "veg",
                                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

        // Write your code here

        @Override
    public ArrayList<Recipe> getRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>(recipeBook.values());

        return recipes;
    }

    @Override
    public Recipe getRecipeById(int recipeId) {
        Recipe recipe = recipeBook.get(recipeId);

        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return recipe;
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        int lastid=recipeBook.size();
        lastid+=1;
        recipe.setRecipeId(lastid);
        recipeBook.put(lastid,recipe);
        return recipe;
    }

    @Override
    public Recipe updateRecipe(int recipeId, Recipe recipe) {
       Recipe exist=recipeBook.get(recipeId);

        if (exist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (recipe.getRecipeName() != null) {
            exist.setRecipeName(recipe.getRecipeName());
        }

        if (recipe.getRecipeType() != null) {
            exist.setRecipeType(recipe.getRecipeType());
        }

        if (recipe.getIngredients() != null) {
            exist.setIngredients(recipe.getIngredients());
        }

        return exist;
    }

    @Override
    public void deleteRecipe(int id) {

        Recipe recipe=recipeBook.get(id);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            recipeBook.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}

