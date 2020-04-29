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
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    private Long recipeId;

    protected Favorite() {
    }

    public Favorite(User user, Long recipeId) {
        this.user = user;
        this.recipeId = recipeId;
    }

    public String getUser() { // returning only username to prevent infinite loop with user.favorites
        return user.getUsername();
    }
}
