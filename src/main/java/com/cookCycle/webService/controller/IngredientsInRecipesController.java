package com.cookCycle.webService.controller;

import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.service.IIngredientsInRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredientsinrecipes")
public class IngredientsInRecipesController {

    @Autowired
    private IIngredientsInRecipesService ingredientsInRecipesService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<IngredientsInRecipes> getIngredientsInRecipesById(@PathVariable("id") Long id) {
        IngredientsInRecipes ingredientsInRecipes = ingredientsInRecipesService.getIngredientsInRecipesById(id);
        return new ResponseEntity<IngredientsInRecipes>(ingredientsInRecipes, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<IngredientsInRecipes>> getAllIngredientsInRecipess() {
        List<IngredientsInRecipes> list = ingredientsInRecipesService.getAllIngredientsInRecipes();
        return new ResponseEntity<List<IngredientsInRecipes>>(list, HttpStatus.OK);
    }
}
