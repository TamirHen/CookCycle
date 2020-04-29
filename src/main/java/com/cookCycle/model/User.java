package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="User")
public class User {

    @Id
    private String username;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Favorite> favorites;
    protected User() {
    }

    public User(String username) {
        this.username = username;
    }

    @Override
    public String toString() { // Overriding toString to prevent infinite loop with favorite.user
        return "User{" +
                "username='" + username + '\'' +
                ", favorites.size=" + favorites.size() +
                '}';
    }
}
