/*
 * 
 * You can use the following import statements
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.recipe;
 import org.springframework.web.bind.annotation.*;
 import java.util.*;
 import com.example.recipe.RecipeService;
@RestController
public class RecipeController{

    RecipeService service =new RecipeService();
@GetMapping("/recipes")
public ArrayList<Recipe> getTotalRecipes(){
    return service.getRecipes();
}

@PostMapping("/recipes")
public Recipe postRecipe(@RequestBody Recipe recipe){
return service.addRecipe(recipe);
}

@GetMapping("/recipes/{recipeId}")
public Recipe getRecipe(@PathVariable("recipeId") int id){
    return service.getRecipeById(id);
}

@PutMapping("/recipes/{recipeId}")
public Recipe putRecipe(@PathVariable("recipeId") int id,@RequestBody Recipe recipe){
    return service.updateRecipe(id, recipe);
}

@DeleteMapping("/recipes/{recipeId}")
public void removeRecipe(@PathVariable("recipeId") int id){
    service.deleteRecipe(id);
}

}
 