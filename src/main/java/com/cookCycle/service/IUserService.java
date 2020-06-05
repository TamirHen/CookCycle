package com.cookCycle.service;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserByUsername(String username) throws Throwable;
    User addUser(User user);
    List<Favorite> getFavoritesByUsername(String username) throws Throwable;
}
