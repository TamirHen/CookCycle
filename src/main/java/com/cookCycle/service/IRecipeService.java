package com.cookCycle.service;

import com.cookCycle.model.Recipe;

import java.util.List;

public interface IRecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long recipeId) throws Throwable;
    Recipe addRecipe(Recipe recipe) throws Throwable;
}
