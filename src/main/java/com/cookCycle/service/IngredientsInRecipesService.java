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
    public IngredientsInRecipes getIngredientsInRecipesById(int ingredientsInRecipesId) {
        IngredientsInRecipes obj = ingredientsInRecipesRepository.findById(ingredientsInRecipesId).get();
        return obj;
    }

    @Override
    public boolean addIngredientsInRecipes(IngredientsInRecipes ingredientsInRecipes) {
        List<IngredientsInRecipes> list = (List<IngredientsInRecipes>) ingredientsInRecipesRepository.findAll();
        if (list == null) return false;
        for (IngredientsInRecipes r:list) {
            if (r.getId() == 0) return false; // Check that r has valid id.
            if (ingredientsInRecipes.getId() == r.getId()) return false;
        }
        ingredientsInRecipesRepository.save(ingredientsInRecipes);
        return true;
    }

    @Override
    public void updateIngredientsInRecipes(IngredientsInRecipes ingredientsInRecipes) {
        ingredientsInRecipesRepository.save(ingredientsInRecipes);
    }

    @Override
    public void deleteIngredientsInRecipes(int ingredientsInRecipesId) {
        ingredientsInRecipesRepository.delete(getIngredientsInRecipesById(ingredientsInRecipesId));
    }
}
