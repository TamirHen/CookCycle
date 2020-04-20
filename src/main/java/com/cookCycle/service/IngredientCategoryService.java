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
    public IngredientCategory getIngredientCategoryById(int ingredientCategoryId) {
        IngredientCategory obj = ingredientCategoryRepository.findById(ingredientCategoryId).get();
        return obj;
    }

    @Override
    public boolean addIngredientCategory(IngredientCategory ingredientCategory) {
        List<IngredientCategory> list = (List<IngredientCategory>) ingredientCategoryRepository.findAll();
        if (list == null) return false;
        for (IngredientCategory r:list) {
            if (ingredientCategory.getName() == r.getName()) return false;
        }
        ingredientCategoryRepository.save(ingredientCategory);
        return true;
    }

    @Override
    public void updateIngredientCategory(IngredientCategory ingredientCategory) {
        ingredientCategoryRepository.save(ingredientCategory);
    }

    @Override
    public void deleteIngredientCategory(int ingredientCategoryId) {
        ingredientCategoryRepository.delete(getIngredientCategoryById(ingredientCategoryId));
    }
}
