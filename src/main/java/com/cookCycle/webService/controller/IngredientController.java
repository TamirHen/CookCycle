package com.cookCycle.webService.controller;

import com.cookCycle.model.Ingredient;
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
        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> list = ingredientService.getAllIngredients();
        return new ResponseEntity<List<Ingredient>>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) throws Throwable {
        Ingredient dbIngredient = ingredientService.addIngredient(ingredient);
        return new ResponseEntity<Ingredient>(dbIngredient, HttpStatus.CREATED);
    }
}
