package com.cookCycle.webService.controller;

import com.cookCycle.model.Ingredient;
import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.model.Recipe;
import com.cookCycle.service.IIngredientService;
import com.cookCycle.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping(path = "/ingredient")
public class IngredientController {

    @Autowired
    private IIngredientService ingredientService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long id) throws Throwable {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        ResponseEntity<Ingredient> response = new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
        System.out.println("GET Request: ingredient/getbyid\nResponse: " + response.getStatusCode());
        return response;
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> list = ingredientService.getAllIngredients();
        ResponseEntity<List<Ingredient>> response = new ResponseEntity<List<Ingredient>>(list, HttpStatus.OK);
        System.out.println("GET Request: ingredient/getall\nResponse: " + response.getStatusCode());
        return response;


    }

    @PostMapping(path = "/add")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) throws Throwable {
        Ingredient dbIngredient = ingredientService.addIngredient(ingredient);
        ResponseEntity<Ingredient> response = new ResponseEntity<Ingredient>(dbIngredient, HttpStatus.CREATED);
        System.out.println("POST Request: ingredient/add\nResponse: " + response.getStatusCode());
        return response;
    }
}
