package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;
    private Long apiId;
    private String name;
    private Long categoryId;
    private String image;
    private Boolean isGlutenFree;
    private Boolean isVegetarian;
    private Boolean isVegan;
    private Boolean isDairyFree;

    protected Ingredient() {
    }

    public Ingredient(Long apiId, String name, Long categoryId, String image, Boolean isGlutenFree, Boolean isVegetarian, Boolean isVegan, Boolean isDairyFree) {
        this.apiId = apiId;
        this.name = name;
        this.categoryId = categoryId;
        this.image = image;
        this.isGlutenFree = isGlutenFree;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isDairyFree = isDairyFree;
    }

}
