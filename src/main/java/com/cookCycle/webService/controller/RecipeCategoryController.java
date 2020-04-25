package com.cookCycle.webService.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.cookCycle.model.RecipeCategory;
import com.cookCycle.service.IRecipeCategoryService;

@RestController
@RequestMapping(path = "/recipecategory")
public class RecipeCategoryController {

    @Autowired
    private IRecipeCategoryService recipeCategoryService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<RecipeCategory> getRecipeCategoryById(@PathVariable("id") Integer id) {
        RecipeCategory recipeCategory = recipeCategoryService.getRecipeCategoryById(id);
        return new ResponseEntity<RecipeCategory>(recipeCategory, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<RecipeCategory>> getAllRecipeCategories() {
        List<RecipeCategory> list = recipeCategoryService.getAllRecipeCategories();
        return new ResponseEntity<List<RecipeCategory>>(list, HttpStatus.OK);
    }

}
