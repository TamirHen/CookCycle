package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    protected RecipeCategory() {
    }

    public RecipeCategory(String name) {
        this.name = name;
    }
}
