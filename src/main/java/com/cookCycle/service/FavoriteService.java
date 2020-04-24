package com.cookCycle.service;

import com.cookCycle.model.Favorite;
import com.cookCycle.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService implements IFavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public List<Favorite> getAllFavorites() {
        List<Favorite> list = new ArrayList<>();
        favoriteRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Favorite getFavoriteById(int favoriteId) {
        Favorite obj = favoriteRepository.findById(favoriteId).get();
        return obj;
    }

    @Override
    public boolean addFavorite(Favorite favorite) {
        List<Favorite> list = (List<Favorite>) favoriteRepository.findAll();
        if (list == null) return false;
        for (Favorite r:list) {
            if (favorite.getId() == r.getId()) return false;
        }
            favoriteRepository.save(favorite);
            return true;
    }

    @Override
    public void updateFavorite(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    @Override
    public void deleteFavorite(int favoriteId) {
        favoriteRepository.delete(getFavoriteById(favoriteId));
    }
}
