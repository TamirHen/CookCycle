package com.cookCycle.service;

import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.repository.IngredientsInRecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientsInRecipesService implements IIngredientsInRecipesService {
    @Autowired
    private IngredientsInRecipesRepository ingredientsInRecipesRepository;

    @Override
    public List<IngredientsInRecipes> getAllIngredientsInRecipes() {
        List<IngredientsInRecipes> list = new ArrayList<>();
        ingredientsInRecipesRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public IngredientsInRecipes getIngredientsInRecipesById(Long ingredientsInRecipesId) {
        IngredientsInRecipes obj = ingredientsInRecipesRepository.findById(ingredientsInRecipesId).get();
        return obj;
    }
    @Override
    public IngredientsInRecipes addIngredientsInRecipes(IngredientsInRecipes ingredientsInRecipes) {
        return ingredientsInRecipesRepository.save(ingredientsInRecipes);
    }
}
