package com.cookCycle.repository;

import com.cookCycle.model.Ingredient;
import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
    List<Recipe> findAllByIdIn(List<Long> ids);
}
