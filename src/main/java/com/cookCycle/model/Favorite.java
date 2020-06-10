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

    /*
    * Returning only username to prevent infinite loop with user.favorites.
    */
    public String getUser() {
        return user.getUsername();
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", username=" + user.getUsername() +
                ", recipeId=" + recipeId +
                '}';
    }
    public Long getRecipeId() {
        return this.recipeId;
    }
}
