package com.cookCycle.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private String username;

    protected User() {
    }

    public User(String username) {
        this.username = username;
    }
}
