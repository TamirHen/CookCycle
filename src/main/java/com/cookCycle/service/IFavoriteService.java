package com.cookCycle.service;

import com.cookCycle.model.Favorite;

import java.util.List;

public interface IFavoriteService {
    List<Favorite> getAllFavorites();
    Favorite getFavoriteById(Long favoriteId) throws Throwable;
    Favorite addFavorite(Favorite favorite);
    void deleteFavorite(Favorite favorite) throws Throwable;
}
