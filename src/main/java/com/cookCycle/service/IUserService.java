package com.cookCycle.service;

import com.cookCycle.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserByUsername(String username);
    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(String username);
}
