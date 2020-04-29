package com.cookCycle.webService.controller;

import com.cookCycle.model.Favorite;
import com.cookCycle.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/favorite")
public class FavoriteController {

    @Autowired
    private IFavoriteService favoriteService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable("id") Long id) throws Throwable {
        Favorite favorite = favoriteService.getFavoriteById(id);
        return new ResponseEntity<Favorite>(favorite, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> list = favoriteService.getAllFavorites();
        return new ResponseEntity<List<Favorite>>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite, UriComponentsBuilder builder) {
        Favorite dbFavorite = favoriteService.addFavorite(favorite);
        return new ResponseEntity<Favorite>(dbFavorite, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable("id") Long id) throws Throwable {
        favoriteService.deleteFavorite(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
