package com.cookCycle.repository;

import com.cookCycle.model.Ingredient;
import com.cookCycle.model.IngredientsInRecipes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientsInRecipesRepository extends CrudRepository<IngredientsInRecipes, Long>{
    List<IngredientsInRecipes> findDistinctByStringContaining(String ingredient);
}
