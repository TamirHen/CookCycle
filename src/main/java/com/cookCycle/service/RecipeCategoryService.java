package com.cookCycle.service;

import com.cookCycle.model.RecipeCategory;
import com.cookCycle.repository.RecipeCategoryRepository;
import com.cookCycle.service.Handler.RecipeCategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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
    public RecipeCategory getRecipeCategoryById(Long recipeCategoryId) throws Throwable {
        RecipeCategory obj = recipeCategoryRepository.findById(recipeCategoryId).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new RecipeCategoryNotFoundException(recipeCategoryId);
            }
        });
        return obj;
    }
}
