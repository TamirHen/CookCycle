package com.cookCycle.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Favorite {
    @Id
    private int id;
    private String username;
    private Integer recipeId;

    public Favorite(int id, String username, Integer recipeId) {
        this.id = id;
        this. username = username;
        this.recipeId = recipeId;
    }

    protected Favorite() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "recipeId")
    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favorite favorite = (Favorite) o;

        if (id != favorite.id) return false;
        if (username != null ? !username.equals(favorite.username) : favorite.username != null) return false;
        if (recipeId != null ? !recipeId.equals(favorite.recipeId) : favorite.recipeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (recipeId != null ? recipeId.hashCode() : 0);
        return result;
    }
}
