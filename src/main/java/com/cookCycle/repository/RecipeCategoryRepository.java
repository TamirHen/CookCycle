package com.cookCycle.repository;

import com.cookCycle.model.Ingredient;
import com.cookCycle.model.IngredientCategory;
import com.cookCycle.model.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Long>{

}
