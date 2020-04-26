package com.cookCycle.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="User")
public class User {

    @Id
    private String username;

    protected User() {
    }

    public User(String username) {
        this.username = username;
    }
}
