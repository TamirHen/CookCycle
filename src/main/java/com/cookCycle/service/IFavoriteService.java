package com.cookCycle.service;

import com.cookCycle.model.Favorite;

import java.util.List;

public interface IFavoriteService {
    List<Favorite> getAllFavorites();
    Favorite getFavoriteById(int favoriteId);
    boolean addFavorite(Favorite favorite);
    void updateFavorite(Favorite favorite);
    void deleteFavorite(int favoriteId);
}
