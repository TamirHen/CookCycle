package com.cookCycle.webService.controller;

import com.cookCycle.model.Recipe;
import com.cookCycle.service.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/recipe")
public class RecipeController {

    @Autowired
    private IRecipeService recipeService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Integer id) {
        Recipe recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> list = recipeService.getAllRecipes();
        return new ResponseEntity<List<Recipe>>(list, HttpStatus.OK);
    }

//    @PostMapping(path = "/add")
//    public ResponseEntity<Void> addRecipe(@RequestBody Recipe recipe, UriComponentsBuilder builder) {
//        boolean flag = recipeService.addRecipe(recipe);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/add/{id}").buildAndExpand(recipe.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    @PutMapping("recipe")
//    public ResponseEntity<Recipe> updateArticle(@RequestBody Recipe recipe) {
//        recipeService.updateRecipe(recipe);
//        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
//    }
//
//    @DeleteMapping("recipe/{id}")
//    public ResponseEntity<Void> deleteRecipe(@PathVariable("id") Integer id) {
//        recipeService.deleteRecipe(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

}
