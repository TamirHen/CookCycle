package com.cookCycle.webService.controller;

import com.cookCycle.model.IngredientCategory;
import com.cookCycle.service.IIngredientCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredientcategory")
public class IngredientCategoryController {

    @Autowired
    private IIngredientCategoryService ingredientCategoryService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<IngredientCategory> getIngredientCategoryById(@PathVariable("id") Integer id) {
        IngredientCategory ingredientCategory = ingredientCategoryService.getIngredientCategoryById(id);
        return new ResponseEntity<IngredientCategory>(ingredientCategory, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<IngredientCategory>> getAllIngredientCategories() {
        List<IngredientCategory> list = ingredientCategoryService.getAllIngredientCategories();
        return new ResponseEntity<List<IngredientCategory>>(list, HttpStatus.OK);
    }

}
