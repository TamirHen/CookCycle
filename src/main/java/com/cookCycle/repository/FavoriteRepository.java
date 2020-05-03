package com.cookCycle.repository;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FavoriteRepository extends CrudRepository<Favorite, Long>{
    List<Favorite> getFavoritesByUser(User user);
}
