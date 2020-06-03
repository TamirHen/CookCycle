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
    private String string;

    protected IngredientsInRecipes() {
    }

    public IngredientsInRecipes(String string) {
        this.string = string;
    }

    /*
    * Returning only recipeId to prevent infinite loop with recipe.ingredientsInRecipe.
    */
    public Long getRecipe() {
        return recipe.getId();
    }
}
