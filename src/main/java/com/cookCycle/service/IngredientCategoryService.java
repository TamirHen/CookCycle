package com.cookCycle.service;

import com.cookCycle.model.IngredientCategory;
import com.cookCycle.repository.IngredientCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientCategoryService implements IIngredientCategoryService {
    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Override
    public List<IngredientCategory> getAllIngredientCategories() {
        List<IngredientCategory> list = new ArrayList<>();
        ingredientCategoryRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public IngredientCategory getIngredientCategoryById(Long ingredientCategoryId) {
        IngredientCategory obj = ingredientCategoryRepository.findById(ingredientCategoryId).get();
        return obj;
    }

}
