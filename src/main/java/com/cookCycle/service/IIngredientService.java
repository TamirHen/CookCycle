package com.cookCycle.service;

import com.cookCycle.model.Ingredient;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IIngredientService {
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long ingredientId) throws Throwable;
    Ingredient addIngredient(Ingredient ingredient) throws Throwable;
}
