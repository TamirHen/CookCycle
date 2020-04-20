package com.cookCycle.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Recipe {
    @Id
    private int id;
    private int apiId;
    private String apiSource;
    private String title;
    private String instructions;
    private Integer serving;
    private Time preparationMinutes;
    private Time cookTime;
    private Integer categoryId;
    private String image;
    private String cuisine;
    private Byte isGlutenFree;
    private Byte isVegetarian;
    private Byte isVegan;
    private Byte isDairyFree;

    protected Recipe() {
    }

    public Recipe(int apiId, String apiSource, String title, String instructions, Integer serving, Time preparationMinutes, Time cookTime, Integer categoryId, String image, String cuisine, Byte isGlutenFree, Byte isVegetarian, Byte isVegan, Byte isDairyFree) {
        this.apiId = apiId;
        this.apiSource = apiSource;
        this.title = title;
        this.instructions = instructions;
        this.serving = serving;
        this.preparationMinutes = preparationMinutes;
        this.cookTime = cookTime;
        this.categoryId = categoryId;
        this.image = image;
        this.cuisine = cuisine;
        this.isGlutenFree = isGlutenFree;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isDairyFree = isDairyFree;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    //Only DB Should set the id
    private void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "api_id")
    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    @Basic
    @Column(name = "api_source")
    public String getApiSource() {
        return apiSource;
    }

    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Instructions")
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Basic
    @Column(name = "serving")
    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    @Basic
    @Column(name = "preparationMinutes")
    public Time getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(Time preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    @Basic
    @Column(name = "cookTime")
    public Time getCookTime() {
        return cookTime;
    }

    public void setCookTime(Time cookTime) {
        this.cookTime = cookTime;
    }

    @Basic
    @Column(name = "categoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "cuisine")
    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Basic
    @Column(name = "isGlutenFree")
    public Byte getIsGlutenFree() {
        return isGlutenFree;
    }

    public void setIsGlutenFree(Byte isGlutenFree) {
        this.isGlutenFree = isGlutenFree;
    }

    @Basic
    @Column(name = "isVegetarian")
    public Byte getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(Byte isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    @Basic
    @Column(name = "isVegan")
    public Byte getIsVegan() {
        return isVegan;
    }

    public void setIsVegan(Byte isVegan) {
        this.isVegan = isVegan;
    }

    @Basic
    @Column(name = "isDairyFree")
    public Byte getIsDairyFree() {
        return isDairyFree;
    }

    public void setIsDairyFree(Byte isDairyFree) {
        this.isDairyFree = isDairyFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != recipe.id) return false;
        if (apiId != recipe.apiId) return false;
        if (apiSource != null ? !apiSource.equals(recipe.apiSource) : recipe.apiSource != null) return false;
        if (title != null ? !title.equals(recipe.title) : recipe.title != null) return false;
        if (instructions != null ? !instructions.equals(recipe.instructions) : recipe.instructions != null)
            return false;
        if (serving != null ? !serving.equals(recipe.serving) : recipe.serving != null) return false;
        if (preparationMinutes != null ? !preparationMinutes.equals(recipe.preparationMinutes) : recipe.preparationMinutes != null)
            return false;
        if (cookTime != null ? !cookTime.equals(recipe.cookTime) : recipe.cookTime != null) return false;
        if (categoryId != null ? !categoryId.equals(recipe.categoryId) : recipe.categoryId != null) return false;
        if (image != null ? !image.equals(recipe.image) : recipe.image != null) return false;
        if (cuisine != null ? !cuisine.equals(recipe.cuisine) : recipe.cuisine != null) return false;
        if (isGlutenFree != null ? !isGlutenFree.equals(recipe.isGlutenFree) : recipe.isGlutenFree != null)
            return false;
        if (isVegetarian != null ? !isVegetarian.equals(recipe.isVegetarian) : recipe.isVegetarian != null)
            return false;
        if (isVegan != null ? !isVegan.equals(recipe.isVegan) : recipe.isVegan != null) return false;
        if (isDairyFree != null ? !isDairyFree.equals(recipe.isDairyFree) : recipe.isDairyFree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + apiId;
        result = 31 * result + (apiSource != null ? apiSource.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (instructions != null ? instructions.hashCode() : 0);
        result = 31 * result + (serving != null ? serving.hashCode() : 0);
        result = 31 * result + (preparationMinutes != null ? preparationMinutes.hashCode() : 0);
        result = 31 * result + (cookTime != null ? cookTime.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (cuisine != null ? cuisine.hashCode() : 0);
        result = 31 * result + (isGlutenFree != null ? isGlutenFree.hashCode() : 0);
        result = 31 * result + (isVegetarian != null ? isVegetarian.hashCode() : 0);
        result = 31 * result + (isVegan != null ? isVegan.hashCode() : 0);
        result = 31 * result + (isDairyFree != null ? isDairyFree.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", apiId=" + apiId +
                ", apiSource='" + apiSource + '\'' +
                ", title='" + title + '\'' +
                ", instructions='" + instructions + '\'' +
                ", serving=" + serving +
                ", preparationMinutes=" + preparationMinutes +
                ", cookTime=" + cookTime +
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
