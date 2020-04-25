package com.cookCycle.service;

import com.cookCycle.model.RecipeCategory;
import com.cookCycle.repository.RecipeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeCategoryService implements IRecipeCategoryService {
    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @Override
    public List<RecipeCategory> getAllRecipeCategories() {
        List<RecipeCategory> list = new ArrayList<>();
        recipeCategoryRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public RecipeCategory getRecipeCategoryById(int recipeCategoryId) {
        RecipeCategory obj = recipeCategoryRepository.findById(recipeCategoryId).get();
        return obj;
    }
}
