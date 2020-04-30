package com.cookCycle.service;
import com.cookCycle.model.RecipeCategory;
import java.util.List;

public interface IRecipeCategoryService {
    List<RecipeCategory> getAllRecipeCategories();
    RecipeCategory getRecipeCategoryById(Long recipeCategoryId) throws Throwable;
}
