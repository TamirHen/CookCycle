package com.cookCycle.service;

import com.cookCycle.model.Ingredient;
import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.model.Recipe;
import com.cookCycle.repository.IngredientRepository;
import com.cookCycle.repository.RecipeRepository;
import com.cookCycle.service.Handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class RecipeService implements IRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> list = new ArrayList<>();
        recipeRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Recipe getRecipeById(Long recipeId) throws Throwable {
        Recipe obj = recipeRepository.findById(recipeId).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new RecipeNotFoundException(recipeId);
            }
        });
        return obj;
    }


    @Override
    public Recipe addRecipe(Recipe recipe) throws Throwable {
        recipeRepository.save(recipe);
        return recipe;
    }
}
