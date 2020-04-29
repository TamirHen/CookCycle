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
    private String ingredientName;
    private Double amount;
    private String unit;
    private String unitAndAmountString;

    protected IngredientsInRecipes() {
    }

    public IngredientsInRecipes(Long ingredientId, String ingredientName, Double amount, String unit, String unitAndAmountString) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.unit = unit;
        this.unitAndAmountString = unitAndAmountString;
    }

    /*
    * Returning only recipeId to prevent infinite loop with recipe.ingredientsInRecipe.
    */
    public Long getRecipe() {
        return recipe.getId();
    }
}
