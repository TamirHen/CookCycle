package com.cookCycle.webService.controller;

import com.cookCycle.model.Recipe;
import com.cookCycle.service.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/recipe")
public class RecipeController {

    @Autowired
    private IRecipeService recipeService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) throws Throwable {
        Recipe recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> list = recipeService.getAllRecipes();
        return new ResponseEntity<List<Recipe>>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Recipe> addUser(@RequestBody Recipe recipe, UriComponentsBuilder builder) throws Throwable {
        Recipe dbRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<Recipe>(dbRecipe, HttpStatus.CREATED);
    }

}
