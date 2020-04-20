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

//    @PostMapping(path = "/add")
//    public ResponseEntity<Void> addRecipeCategory(@RequestBody RecipeCategory recipeCategory, UriComponentsBuilder builder) {
//        boolean flag = recipeCategoryService.addRecipeCategory(recipeCategory);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/add/{id}").buildAndExpand(recipeCategory.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    @PutMapping("recipeCategory")
//    public ResponseEntity<RecipeCategory> updateArticle(@RequestBody RecipeCategory recipeCategory) {
//        recipeCategoryService.updateRecipeCategory(recipeCategory);
//        return new ResponseEntity<RecipeCategory>(recipeCategory, HttpStatus.OK);
//    }
//
//    @DeleteMapping("recipeCategory/{id}")
//    public ResponseEntity<Void> deleteRecipeCategory(@PathVariable("id") Integer id) {
//        recipeCategoryService.deleteRecipeCategory(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

}
