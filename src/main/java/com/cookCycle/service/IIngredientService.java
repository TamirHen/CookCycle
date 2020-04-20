package com.cookCycle.service;

import com.cookCycle.model.Ingredient;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(int ingredientId);
    boolean addIngredient(Ingredient ingredient);
    void updateIngredient(Ingredient ingredient);
    void deleteIngredient(int ingredientId);
}
