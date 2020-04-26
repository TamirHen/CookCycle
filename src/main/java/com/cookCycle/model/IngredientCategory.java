package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class IngredientCategory {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    protected IngredientCategory() {
    }

    public IngredientCategory(String name) {
        this.name = name;
    }
}
