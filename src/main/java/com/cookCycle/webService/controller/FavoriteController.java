package com.cookCycle.webService.controller;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.Ingredient;
import com.cookCycle.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/favorite")
public class FavoriteController {

    @Autowired
    private IFavoriteService favoriteService;

    @GetMapping(path = "/getbyid/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable("id") Long id) throws Throwable {
        Favorite favorite = favoriteService.getFavoriteById(id);
        ResponseEntity<Favorite> response = new ResponseEntity<Favorite>(favorite, HttpStatus.OK);
        System.out.println("GET Request: favorite/getbyid\nResponse: " + response.getStatusCode());
        return response;
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> list = favoriteService.getAllFavorites();
        ResponseEntity<List<Favorite>> response = new ResponseEntity<List<Favorite>>(list, HttpStatus.OK);
        System.out.println("GET Request: favorite/getall\nResponse: " + response.getStatusCode());
        return response;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Favorite> addFavorite(@RequestBody HashMap<String, String> favorite) throws Throwable {
        Favorite dbFavorite = favoriteService.addFavorite(favorite);
        ResponseEntity<Favorite> response = new ResponseEntity<Favorite>(dbFavorite, HttpStatus.CREATED);
        System.out.println("POST Request: favorite/add\nResponse: " + response.getStatusCode());
        return response;
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteFavorite(@RequestBody Favorite favorite) throws Throwable {
        favoriteService.deleteFavorite(favorite);
        ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
        System.out.println("Post Request: favorite/delete\nResponse: " + response.getStatusCode());
        return response;

    }

}
