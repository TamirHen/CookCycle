package com.cookCycle.webService.controller;

import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.service.IIngredientsInRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredientsinrecipes")
public class IngredientsInRecipesController {

    @Autowired
    private IIngredientsInRecipesService ingredientsInRecipesService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<IngredientsInRecipes> getIngredientsInRecipesById(@PathVariable("id") Integer id) {
        IngredientsInRecipes ingredientsInRecipes = ingredientsInRecipesService.getIngredientsInRecipesById(id);
        return new ResponseEntity<IngredientsInRecipes>(ingredientsInRecipes, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<IngredientsInRecipes>> getAllIngredientsInRecipess() {
        List<IngredientsInRecipes> list = ingredientsInRecipesService.getAllIngredientsInRecipes();
        return new ResponseEntity<List<IngredientsInRecipes>>(list, HttpStatus.OK);
    }

//    @PostMapping(path = "/add")
//    public ResponseEntity<Void> addIngredientsInRecipes(@RequestBody IngredientsInRecipes ingredientsInRecipes, UriComponentsBuilder builder) {
//        boolean flag = ingredientsInRecipesService.addIngredientsInRecipes(ingredientsInRecipes);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/add/{id}").buildAndExpand(ingredientsInRecipes.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    @PutMapping("ingredientsInRecipes")
//    public ResponseEntity<IngredientsInRecipes> updateArticle(@RequestBody IngredientsInRecipes ingredientsInRecipes) {
//        ingredientsInRecipesService.updateIngredientsInRecipes(ingredientsInRecipes);
//        return new ResponseEntity<IngredientsInRecipes>(ingredientsInRecipes, HttpStatus.OK);
//    }
//
//    @DeleteMapping("ingredientsInRecipes/{id}")
//    public ResponseEntity<Void> deleteIngredientsInRecipes(@PathVariable("id") Integer id) {
//        ingredientsInRecipesService.deleteIngredientsInRecipes(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

}
