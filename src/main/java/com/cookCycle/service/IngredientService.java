package com.cookCycle.service;

import com.cookCycle.model.Ingredient;
import com.cookCycle.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService implements IIngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> list = new ArrayList<>();
        ingredientRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Ingredient getIngredientById(int ingredientId) {
        Ingredient obj = ingredientRepository.findById(ingredientId).get();
        return obj;
    }
}
