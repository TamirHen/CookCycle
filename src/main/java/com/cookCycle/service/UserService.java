package com.cookCycle.service;

import com.cookCycle.model.User;
import com.cookCycle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public User getUserByUsername(String username) {
        User obj = userRepository.findById(username).get();
        return obj;
    }

    @Override
    public boolean addUser(User user) {
        List<User> list = (List<User>) userRepository.findAll();
        if (list == null) return false;
        for (User r:list) {
            if (user.getUsername() == r.getUsername()) return false;
        }
            userRepository.save(user);
            return true;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.delete(getUserByUsername(username));
    }
}
