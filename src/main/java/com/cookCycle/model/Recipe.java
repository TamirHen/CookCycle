package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Recipe")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String name;
    private String method;
    private String description;
    private String difficulty;
    @OneToMany(mappedBy = "recipe",fetch = FetchType.EAGER)
    List<IngredientsInRecipes> ingredientsInRecipe;
    private String servings;
    private String prepTime;
    private String cookTime;
    private String img_url;

    private String fibre;
    private String carbs;
    private String sugars;
    private String fat;
    private String saturates;
    private String protein;
    private String salt;
    private String kcal;

    protected Recipe() {
    }

    public Recipe(String author, String name, String method, List<IngredientsInRecipes> ingredientsInRecipe, String servings, String prepTime, String cookTime, String img_url) {
        this.author = author;
        this.name = name;
        this.method = method;
        this.ingredientsInRecipe = ingredientsInRecipe;
        this.servings = servings;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.img_url = img_url;
    }

    /*
    * Overriding toString to prevent infinite loop with ingredientInRecipe.Recipe.
    */
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", method='" + method + '\'' +
                ", ingredientsInRecipe size=" + ingredientsInRecipe.size() +
                ", servings=" + servings +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", img_url='" + img_url + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
