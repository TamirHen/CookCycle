package com.cookCycle.model;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    private int id;
    private int apiId;
    private String name;
    private Integer categoryId;
    private String image;
    private Byte isGlutenFree;
    private Byte isVegetarian;
    private Byte isVegan;
    private Byte isDairyFree;

    protected Ingredient() {
    }

    public Ingredient(int apiId, String name, Integer categoryId, String image, Byte isGlutenFree, Byte isVegetarian, Byte isVegan, Byte isDairyFree) {
        this.apiId = apiId;
        this.name = name;
        this.categoryId = categoryId;
        this.image = image;
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
    public void setId(int id) {
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (apiId != that.apiId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (isGlutenFree != null ? !isGlutenFree.equals(that.isGlutenFree) : that.isGlutenFree != null) return false;
        if (isVegetarian != null ? !isVegetarian.equals(that.isVegetarian) : that.isVegetarian != null) return false;
        if (isVegan != null ? !isVegan.equals(that.isVegan) : that.isVegan != null) return false;
        if (isDairyFree != null ? !isDairyFree.equals(that.isDairyFree) : that.isDairyFree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + apiId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (isGlutenFree != null ? isGlutenFree.hashCode() : 0);
        result = 31 * result + (isVegetarian != null ? isVegetarian.hashCode() : 0);
        result = 31 * result + (isVegan != null ? isVegan.hashCode() : 0);
        result = 31 * result + (isDairyFree != null ? isDairyFree.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", apiId=" + apiId +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", image='" + image + '\'' +
                ", isGlutenFree=" + isGlutenFree +
                ", isVegetarian=" + isVegetarian +
                ", isVegan=" + isVegan +
                ", isDairyFree=" + isDairyFree +
                '}';
    }
}
