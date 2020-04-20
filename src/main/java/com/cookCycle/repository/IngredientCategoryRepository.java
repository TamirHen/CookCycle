package com.cookCycle.repository;

import com.cookCycle.model.Ingredient;
import com.cookCycle.model.IngredientCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientCategoryRepository extends CrudRepository<IngredientCategory, Integer>{

}
