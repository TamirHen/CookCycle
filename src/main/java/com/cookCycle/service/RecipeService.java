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
    public Recipe getRecipeById(Long recipeId) {
        Recipe obj = recipeRepository.findById(recipeId).get();
        return obj;
    }
}
