package com.cookCycle.service;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.Recipe;
import com.cookCycle.model.User;
import com.cookCycle.repository.FavoriteRepository;
import com.cookCycle.repository.RecipeRepository;
import com.cookCycle.repository.UserRepository;
import com.cookCycle.service.Handler.FavoriteAlreadyExist;
import com.cookCycle.service.Handler.FavoriteNotFoundException;
import com.cookCycle.service.Handler.RecipeNotFoundException;
import com.cookCycle.service.Handler.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
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
    public Favorite getFavoriteById(Long favoriteId) throws Throwable {
        Favorite obj = favoriteRepository.findById(favoriteId).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new FavoriteNotFoundException(favoriteId);
            }
        });
        return obj;
    }

    @Override
    public Favorite addFavorite(Favorite favorite) {
        List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();
        List<User> users = (List<User>) userRepository.findAll();
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();

        if (users == null) throw new NullPointerException("No users in the DB");
        if (!(users.stream().map(User::getUsername).collect(Collectors.toList()).contains(favorite.getUser()))) // checks if the user exists.
            throw new UserNotFoundException(favorite.getUser());

        if (recipes == null) throw new NullPointerException("No recipes in the DB");
        if (!(recipes.stream().map(Recipe::getId).collect(Collectors.toList()).contains(favorite.getRecipeId()))) // checks if the recipe exists.
            throw new RecipeNotFoundException(favorite.getRecipeId());

        for (Favorite f:favorites) {
            if (favorite.getUser().equals(f.getUser()) && favorite.getRecipeId().equals(f.getRecipeId())) // checks if the user already have this favorite.
                throw new FavoriteAlreadyExist(f.getId());
        }
            return favoriteRepository.save(favorite);
    }

    @Override
    public void deleteFavorite(Long favoriteId) throws Throwable {
        favoriteRepository.delete(getFavoriteById(favoriteId));
    }
}
