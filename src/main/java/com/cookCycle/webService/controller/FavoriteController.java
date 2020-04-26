package com.cookCycle.webService.controller;

import com.cookCycle.model.Favorite;
import com.cookCycle.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable("id") Long id) {
        Favorite favorite = favoriteService.getFavoriteById(id);
        return new ResponseEntity<Favorite>(favorite, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> list = favoriteService.getAllFavorites();
        return new ResponseEntity<List<Favorite>>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Void> addFavorite(@RequestBody Favorite favorite, UriComponentsBuilder builder) {
        boolean flag = favoriteService.addFavorite(favorite);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/add/{id}").buildAndExpand(favorite.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable("id") Long id) {
        favoriteService.deleteFavorite(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
