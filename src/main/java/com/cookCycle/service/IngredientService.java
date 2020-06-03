package com.cookCycle.service;

import com.cookCycle.model.Ingredient;
import com.cookCycle.repository.IngredientRepository;
import com.cookCycle.service.Handler.IngredientAlreadyExist;
import com.cookCycle.service.Handler.IngredientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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
    public Ingredient getIngredientById(Long ingredientId) throws Throwable {
        Ingredient obj = ingredientRepository.findById(ingredientId).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                throw new IngredientNotFoundException(ingredientId);
            }
        });
        return obj;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) throws Throwable {
        return ingredientRepository.save(ingredient);
    }
}
