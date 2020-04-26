package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="IngredientCategory")
public class IngredientCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    protected IngredientCategory() {
    }

    public IngredientCategory(String name) {
        this.name = name;
    }
}
