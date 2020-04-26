package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class IngredientsInRecipes {

    @Id
    @GeneratedValue
    private Long id;
    private Long recipeId;
    private Long ingredientId;
    private Double amount;
    private String unit;
    private String unitAndAmountString;

    protected IngredientsInRecipes() {
    }

    public IngredientsInRecipes(Long recipeId, Long ingredientId, Double amount, String unit, String unitAndAmountString) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.amount = amount;
        this.unit = unit;
        this.unitAndAmountString = unitAndAmountString;
    }
}
