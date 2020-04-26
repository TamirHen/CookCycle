package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;
    private Long apiId;
    private String apiSource;
    private String title;
    private String instructions;
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

    public Recipe(Long apiId, String apiSource, String title, String instructions, Integer serving, Integer preparationMinutes, Integer cookTimeMinutes, Long categoryId, String image, String cuisine, Boolean isGlutenFree, Boolean isVegetarian, Boolean isVegan, Boolean isDairyFree) {
        this.apiId = apiId;
        this.apiSource = apiSource;
        this.title = title;
        this.instructions = instructions;
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
}
