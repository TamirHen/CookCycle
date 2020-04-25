package com.cookCycle.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredientsInRecipes {
    @Id
    private int id;
    private Integer recipeId;
    private Integer ingredientId;
    private Double amount;
    private String unit;
    private String unitAndAmountString;

    protected IngredientsInRecipes() {
    }

    public IngredientsInRecipes(Integer recipeId, Integer ingredientId, Double amount, String unit, String unitAndAmountString) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.amount = amount;
        this.unit = unit;
        this.unitAndAmountString = unitAndAmountString;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    //Only DB Should set the id
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "recipeId")
    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipe) {
        this.recipeId = recipe;
    }

    @Basic
    @Column(name = "ingredientId")
    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredient) {
        this.ingredientId = ingredient;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "unitAndAmountString")
    public String getUnitAndAmountString() {
        return unitAndAmountString;
    }

    public void setUnitAndAmountString(String unitAndAmountString) {
        this.unitAndAmountString = unitAndAmountString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientsInRecipes that = (IngredientsInRecipes) o;

        if (id != that.id) return false;
        if (recipeId != null ? !recipeId.equals(that.recipeId) : that.recipeId != null) return false;
        if (ingredientId != null ? !ingredientId.equals(that.ingredientId) : that.ingredientId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (unitAndAmountString != null ? !unitAndAmountString.equals(that.unitAndAmountString) : that.unitAndAmountString != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (recipeId != null ? recipeId.hashCode() : 0);
        result = 31 * result + (ingredientId != null ? ingredientId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (unitAndAmountString != null ? unitAndAmountString.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IngredientsInRecipes{" +
                "id=" + id +
                ", recipe=" + recipeId +
                ", ingredient=" + ingredientId +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", unitAndAmountString='" + unitAndAmountString + '\'' +
                '}';
    }
}
