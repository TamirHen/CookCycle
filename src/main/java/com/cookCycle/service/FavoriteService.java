package com.cookCycle.service;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.Recipe;
import com.cookCycle.model.User;
import com.cookCycle.repository.FavoriteRepository;
import com.cookCycle.repository.RecipeRepository;
import com.cookCycle.repository.UserRepository;
import com.cookCycle.service.Handler.*;
//import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    public Favorite addFavorite(HashMap<String, String> favorite) throws Throwable {
        List<Favorite> userFavorites = favoriteRepository.getAllByUser(userRepository.findById(favorite.get("username")).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new UserNotFoundException(favorite.get("username"));
            }
        }));

        if (userFavorites.stream().map(f -> f.getRecipeId()).collect(Collectors.toList()).contains(Long.valueOf(favorite.get("recipeId"))))
            throw new FavoriteAlreadyExist();


        return favoriteRepository.save(new Favorite(userRepository.findById(favorite.get("username")).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new UserNotFoundException(favorite.get("username"));
            }
        }), Long.valueOf(favorite.get("recipeId"))));
    }

    @Override
    public void deleteFavorite(Favorite favorite) throws Throwable {

        User user = userRepository.findById(favorite.getUser()).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new UserNotFoundException(favorite.getUser());
            }
        });
        if (!favoriteRepository.getAllByUser(user).stream().map(f -> f.getRecipeId()).collect(Collectors.toList()).contains(favorite.getRecipeId()))
            throw new FavoriteNotFoundForThisUserException(favorite.getUser(), favorite.getRecipeId());
        Favorite toDelete = favoriteRepository.getFirstByUserAndRecipeId(user, favorite.getRecipeId());
        favoriteRepository.delete(toDelete);


    }
}
