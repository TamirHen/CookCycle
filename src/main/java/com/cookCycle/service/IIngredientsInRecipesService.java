package com.cookCycle.service;

import com.cookCycle.model.IngredientsInRecipes;

import java.util.List;

public interface IIngredientsInRecipesService {
    List<IngredientsInRecipes> getAllIngredientsInRecipes();
    IngredientsInRecipes getIngredientsInRecipesById(Long ingredientsInRecipesId);
    IngredientsInRecipes addIngredientsInRecipes(IngredientsInRecipes ingredientsInRecipes);
}
