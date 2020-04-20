package com.cookCycle.service;
import com.cookCycle.model.RecipeCategory;
import java.util.List;

public interface IRecipeCategoryService {
    List<RecipeCategory> getAllRecipeCategories();
    RecipeCategory getRecipeCategoryById(int recipeCategoryId);
    boolean addRecipeCategory(RecipeCategory recipeCategory);
    void updateRecipeCategory(RecipeCategory recipeCategory);
    void deleteRecipeCategory(int recipeCategoryId);
}
