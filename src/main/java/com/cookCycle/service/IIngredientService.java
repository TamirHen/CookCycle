package com.cookCycle.service;

import com.cookCycle.model.Ingredient;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long ingredientId);
}
