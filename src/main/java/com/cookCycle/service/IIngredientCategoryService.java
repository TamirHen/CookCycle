package com.cookCycle.service;

import com.cookCycle.model.IngredientCategory;
import com.cookCycle.model.IngredientsInRecipes;

import java.util.List;

public interface IIngredientCategoryService {
    List<IngredientCategory> getAllIngredientCategories();
    IngredientCategory getIngredientCategoryById(int ingredientCategoryId);
    boolean addIngredientCategory(IngredientCategory ingredientCategory);
    void updateIngredientCategory(IngredientCategory ingredientCategory);
    void deleteIngredientCategory(int ingredientCategoryId);
}
