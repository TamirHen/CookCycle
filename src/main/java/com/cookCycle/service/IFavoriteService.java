package com.cookCycle.service;

import com.cookCycle.model.Favorite;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public interface IFavoriteService {
    List<Favorite> getAllFavorites();
    Favorite getFavoriteById(Long favoriteId) throws Throwable;
    Favorite addFavorite(HashMap<String, String> favorite) throws Throwable;
    void deleteFavorite(Favorite favorite) throws Throwable;
}
