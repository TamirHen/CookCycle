package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="IngredientsInRecipes")
public class IngredientsInRecipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "recipeId", nullable = false)
    private Recipe recipe;
    private Long ingredientId;
    private Double amount;
    private String unit;
    private String unitAndAmountString;

    protected IngredientsInRecipes() {
    }

    public IngredientsInRecipes(Long ingredientId, Double amount, String unit, String unitAndAmountString) {
        this.ingredientId = ingredientId;
        this.amount = amount;
        this.unit = unit;
        this.unitAndAmountString = unitAndAmountString;
    }

    public Long getRecipe() { // returning only recipeId to prevent infinite loop with recipe.ingredientsInRecipe
        return recipe.getId();
    }
}
