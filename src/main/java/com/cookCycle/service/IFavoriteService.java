package com.cookCycle.service;

import com.cookCycle.model.Favorite;

import java.util.List;

public interface IFavoriteService {
    List<Favorite> getAllFavorites();
    Favorite getFavoriteById(Long favoriteId);
    boolean addFavorite(Favorite favorite);
    void deleteFavorite(Long favoriteId);
}
