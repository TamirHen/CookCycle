package com.cookCycle.service;

import com.cookCycle.model.Recipe;

import java.util.List;

public interface IRecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(int recipeId);
}
