package com.cookCycle.model;

import javax.persistence.*;

@Entity
public class IngredientCategory {
    @Id
    private int id;
    private String name;

    protected IngredientCategory() {
    }

    public IngredientCategory(String name) {
        this.name = name;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientCategory that = (IngredientCategory) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IngredientCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
