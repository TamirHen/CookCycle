package com.cookCycle.webService.controller;

import com.cookCycle.model.Ingredient;
import com.cookCycle.service.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredient")
public class IngredientController {

    @Autowired
    private IIngredientService ingredientService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Integer id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> list = ingredientService.getAllIngredients();
        return new ResponseEntity<List<Ingredient>>(list, HttpStatus.OK);
    }

//    @PostMapping(path = "/add")
//    public ResponseEntity<Void> addIngredient(@RequestBody Ingredient ingredient, UriComponentsBuilder builder) {
//        boolean flag = ingredientService.addIngredient(ingredient);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/add/{id}").buildAndExpand(ingredient.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    @PutMapping("ingredient")
//    public ResponseEntity<Ingredient> updateArticle(@RequestBody Ingredient ingredient) {
//        ingredientService.updateIngredient(ingredient);
//        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
//    }
//
//    @DeleteMapping("ingredient/{id}")
//    public ResponseEntity<Void> deleteIngredient(@PathVariable("id") Integer id) {
//        ingredientService.deleteIngredient(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

}
