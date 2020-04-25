package com.cookCycle.service;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.User;
import com.cookCycle.repository.FavoriteRepository;
import com.cookCycle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;

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
    public void updateUser(User updatedUserWithTheSameUsername) { // to update user, the user provided must be with the same username (username can not be updated).
        List<User> list = (List<User>) userRepository.findAll();
        for (User u:list) {
            if (u.getUsername().equals(updatedUserWithTheSameUsername.getUsername())) {
                userRepository.save(updatedUserWithTheSameUsername);
                return;
            }
        }
        System.out.println(" ---- No user to update ---- ");

    }

    @Override
    public List<Favorite> getAllFavoritesByUsername(String username) {
        List<Favorite> list = new ArrayList<Favorite>();
        for (Favorite favorite:(List<Favorite>)favoriteRepository.findAll()) {
            if (favorite.getUsername().equals(username)){
                list.add(favorite);
            }
        }
        return list;

    }
}
