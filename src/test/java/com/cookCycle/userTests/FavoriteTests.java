package com.cookCycle.favoriteTests;

import com.cookCycle.model.Favorite;
import com.cookCycle.repository.FavoriteRepository;
import com.cookCycle.service.FavoriteService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FavoriteTests {

    @Mock
    private FavoriteRepository favoriteMockRepository;

    @InjectMocks
    private FavoriteService favoriteMockService;

    @Test
    public void getAllFavoritesShouldReturnCorrectNumberOfFavorites() {
        final List<Favorite> favorites = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            favorites.add(new Favorite(i, "test@cookcycle.com", i + 1));
        }
        Mockito.when(favoriteMockRepository.findAll()).thenReturn(favorites);
        final List<Favorite> expected = favoriteMockService.getAllFavorites();

        Assert.assertEquals(expected.size(), favorites.size());
    }

    @Test
    public void testThatWhenCallingGetFavoriteByIdItCallsFindByIdOnce() {
        final int id = 1;
        final Favorite favorite = new Favorite(id);
        Mockito.when(favoriteMockRepository.findById(id)).thenReturn(Optional.of(favorite));
        final Favorite expected = favoriteMockService.getFavoriteById(id);
        Mockito.verify(favoriteMockRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testThatWhenCallingGetByFavoritenameItsReturnFavoriteObject() {
        final int id = "test@cookcycle.com";
        final Favorite favorite = new Favorite(id);
        Mockito.when(favoriteMockRepository.findById(id)).thenReturn(Optional.of(favorite));
        final Favorite expected = favoriteMockService.getFavoriteByFavoritename(id);
        Assert.assertNotNull(expected);
        Assert.assertEquals(favorite, expected);

    }

    @Test
    public void testThatWhenCreatingFavoriteItCallsSaveOnce() {
        final Favorite favorite = new Favorite("test@cookcycle.com");
        Mockito.when(favoriteMockRepository.save(Mockito.any(Favorite.class))).thenReturn(favorite);
        favoriteMockService.addFavorite(favorite);

        Mockito.verify(favoriteMockRepository, Mockito.times(1)).save(favorite);
    }

}
