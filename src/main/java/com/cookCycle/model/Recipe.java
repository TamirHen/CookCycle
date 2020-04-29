package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long apiId;
    private String apiSource;
    private String title;
    private String instructions;
    @OneToMany(mappedBy = "recipe",fetch = FetchType.EAGER)
    List<IngredientsInRecipes> ingredientsInRecipe;
    private Integer serving;
    private Integer preparationMinutes;
    private Integer cookTimeMinutes;
    private Long categoryId;
    private String image;
    private String cuisine;
    private Boolean isGlutenFree;
    private Boolean isVegetarian;
    private Boolean isVegan;
    private Boolean isDairyFree;

    protected Recipe() {
    }

    public Recipe(Long apiId, String apiSource, String title, String instructions, List<IngredientsInRecipes> ingredientsInRecipe, Integer serving, Integer preparationMinutes, Integer cookTimeMinutes, Long categoryId, String image, String cuisine, Boolean isGlutenFree, Boolean isVegetarian, Boolean isVegan, Boolean isDairyFree) {
        this.apiId = apiId;
        this.apiSource = apiSource;
        this.title = title;
        this.instructions = instructions;
        this.ingredientsInRecipe = ingredientsInRecipe;
        this.serving = serving;
        this.preparationMinutes = preparationMinutes;
        this.cookTimeMinutes = cookTimeMinutes;
        this.categoryId = categoryId;
        this.image = image;
        this.cuisine = cuisine;
        this.isGlutenFree = isGlutenFree;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isDairyFree = isDairyFree;
    }

    /*
    * Overriding toString to prevent infinite loop with ingredientInRecipe.Recipe.
    */
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", apiId=" + apiId +
                ", apiSource='" + apiSource + '\'' +
                ", title='" + title + '\'' +
                ", instructions='" + instructions + '\'' +
                ", ingredientsInRecipe size=" + ingredientsInRecipe.size() +
                ", serving=" + serving +
                ", preparationMinutes=" + preparationMinutes +
                ", cookTimeMinutes=" + cookTimeMinutes +
                ", categoryId=" + categoryId +
                ", image='" + image + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", isGlutenFree=" + isGlutenFree +
                ", isVegetarian=" + isVegetarian +
                ", isVegan=" + isVegan +
                ", isDairyFree=" + isDairyFree +
                '}';
    }
}
