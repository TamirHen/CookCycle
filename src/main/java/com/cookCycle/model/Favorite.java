package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Favorite")
@Data
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Long recipeId;

    protected Favorite() {
    }

    public Favorite(String username, Long recipeId) {
        this. username = username;
        this.recipeId = recipeId;
    }
}
