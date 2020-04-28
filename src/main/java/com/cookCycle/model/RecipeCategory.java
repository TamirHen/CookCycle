package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="RecipeCategory")
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    protected RecipeCategory() {
    }

    public RecipeCategory(String name) {
        this.name = name;
    }
}
