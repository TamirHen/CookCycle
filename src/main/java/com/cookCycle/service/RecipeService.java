package com.cookCycle.service;

import com.cookCycle.model.Recipe;
import com.cookCycle.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Recipe getRecipeById(int recipeId) {
        Recipe obj = recipeRepository.findById(recipeId).get();
        return obj;
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        List<Recipe> list = (List<Recipe>) recipeRepository.findAll();
        if (list == null) return false;
        for (Recipe r:list) {
            if (recipe.getApiId() == r.getApiId()) return false;
        }
            recipeRepository.save(recipe);
            return true;
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(int recipeId) {
        recipeRepository.delete(getRecipeById(recipeId));
    }
}
