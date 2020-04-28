package com.cookCycle.service;

import com.cookCycle.model.Ingredient;
import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.model.Recipe;
import com.cookCycle.model.RecipeCategory;
import com.cookCycle.repository.IngredientRepository;
import com.cookCycle.repository.IngredientsInRecipesRepository;
import com.cookCycle.repository.RecipeCategoryRepository;
import com.cookCycle.repository.RecipeRepository;
import com.cookCycle.service.Handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class RecipeService implements IRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private IngredientsInRecipesRepository ingredientsInRecipesRepository;
    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

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
        List<Recipe> list = (List<Recipe>) recipeRepository.findAll();
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        List<RecipeCategory> recipeCategories = (List<RecipeCategory>) recipeCategoryRepository.findAll();

        for (Recipe r:list) {
            if (recipe.getApiId().equals(r.getApiId())) throw new RecipeAlreadyExist(r.getId());
        }
        if (!(recipeCategories.stream().map(RecipeCategory::getId).collect(Collectors.toList()).contains(recipe.getCategoryId()))) // check that recipe.getCategoryId exists.
            throw new RecipeCategoryNotFoundException(recipe.getCategoryId());

        if (recipe.getIsVegan() == true) { // check that vegan recipe is also vegetarian and dairy free.
            if (recipe.getIsDairyFree() == false || recipe.getIsVegetarian() == false)
                throw new RecipeVeganException(recipe);
        }
        for (IngredientsInRecipes iir:recipe.getIngredientsInRecipe()) { // check that all ingredients in the DB.
                ingredientRepository.findById(iir.getIngredientId()).orElseThrow(new Supplier<Throwable>() {
                    @Override
                    public Throwable get() {
                        throw new IngredientNotFoundException(iir.getIngredientId());
                    }
                });
        }

        recipeRepository.save(recipe);
        for (IngredientsInRecipes iir:recipe.getIngredientsInRecipe()) { // save all ingredientsInRecipe to DB
            iir.setRecipe(recipe);
            ingredientsInRecipesRepository.save(iir);
        }

        return recipe;
    }
}
