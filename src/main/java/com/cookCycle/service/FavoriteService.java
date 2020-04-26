package com.cookCycle.service;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.Recipe;
import com.cookCycle.model.User;
import com.cookCycle.repository.FavoriteRepository;
import com.cookCycle.repository.RecipeRepository;
import com.cookCycle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService implements IFavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Favorite> getAllFavorites() {
        List<Favorite> list = new ArrayList<>();
        favoriteRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Favorite getFavoriteById(Long favoriteId) {
        Favorite obj = favoriteRepository.findById(favoriteId).get();
        return obj;
    }

    @Override
    public boolean addFavorite(Favorite favorite) {
        List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();
        List<User> users = (List<User>) userRepository.findAll();
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();

        if (users == null) return false;
        if (!(users.stream().map(User::getUsername).collect(Collectors.toList()).contains(favorite.getUsername()))) // checks if the user exists.
            return false;

        if (recipes == null) return false;
        if (!(recipes.stream().map(Recipe::getId).collect(Collectors.toList()).contains(favorite.getRecipeId()))) // checks if the recipe exists.
            return false;

        if (favorites == null) return false;
        for (Favorite f:favorites) {
            if (favorite.getUsername().equals(f.getUsername()) && favorite.getRecipeId().equals(f.getRecipeId())) // checks if the user already have this favorite.
                return false;
        }
            favoriteRepository.save(favorite);
            return true;
    }

    @Override
    public void deleteFavorite(Long favoriteId) {
        favoriteRepository.delete(getFavoriteById(favoriteId));
    }
}
