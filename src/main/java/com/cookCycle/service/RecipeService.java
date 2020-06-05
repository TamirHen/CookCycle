package com.cookCycle.service;

import com.cookCycle.model.AvailableRecipe;
import com.cookCycle.model.Ingredient;
import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.model.Recipe;
import com.cookCycle.repository.AvailableRecipeRepository;
import com.cookCycle.repository.IngredientRepository;
import com.cookCycle.repository.IngredientsInRecipesRepository;
import com.cookCycle.repository.RecipeRepository;
import com.cookCycle.service.Handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class RecipeService implements IRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientsInRecipesRepository ingredientsInRecipesRepository;
    @Autowired
    private AvailableRecipeRepository availableRecipeRepository;

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

    @Override
    public List<AvailableRecipe> findRecipesWithIngredients(List<String> ingredients) throws Throwable {

        String strIngredientsForQuery = new String();
        for (int i = 0; i < ingredients.size(); i++) {
            strIngredientsForQuery += ("string like '% " + ingredients.get(i) + "%'");

            if (i != ingredients.size() - 1) // if not the last ingredient add 'or' to string.
                strIngredientsForQuery += " or ";
        }

        List<AvailableRecipe> availableRecipes = (List<AvailableRecipe>)availableRecipeRepository.getAvailableRecipes(strIngredientsForQuery);
        for (AvailableRecipe availableRecipe : availableRecipes) {
            availableRecipe.setRecipe(getRecipeById(availableRecipe.getRecipeId()));
        }
        return availableRecipes;
    }

}
