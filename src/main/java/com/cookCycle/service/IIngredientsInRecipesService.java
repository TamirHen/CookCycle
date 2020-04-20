package com.cookCycle.service;

import com.cookCycle.model.IngredientCategory;
import com.cookCycle.model.IngredientsInRecipes;

import java.util.List;

public interface IIngredientsInRecipesService {
    List<IngredientsInRecipes> getAllIngredientsInRecipes();
    IngredientsInRecipes getIngredientsInRecipesById(int ingredientsInRecipesId);
    boolean addIngredientsInRecipes(IngredientsInRecipes ingredientsInRecipes);
    void updateIngredientsInRecipes(IngredientsInRecipes ingredientsInRecipes);
    void deleteIngredientsInRecipes(int ingredientsInRecipesId);

}
