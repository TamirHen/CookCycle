package com.cookCycle.webService.controller;

import com.cookCycle.model.Favorite;
import com.cookCycle.model.User;
import com.cookCycle.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /*
     * Using post request to get by username.
     * Username is an email so it must be sent within the body of the request.
     */
    @PostMapping(path = "/getbyusername")
    public ResponseEntity<User> getUserByUsername(@RequestBody User userRequest) throws Throwable {
        User user = userService.getUserByUsername(userRequest.getUsername());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<User> addUser(@RequestBody User user, UriComponentsBuilder builder) {
        User dbUser = userService.addUser(user);
        return new ResponseEntity<User>(dbUser, HttpStatus.CREATED);
    }

    /*
    * Using post request to get all favorites by username.
    * Username is an email so it must be sent within the body of the request.
    */
    @PostMapping(path = "/getallfavoritesbyusername")
    public ResponseEntity<List<Favorite>> getAllFavoritesByUsername(@RequestBody User userRequest) {
        List<Favorite> favorites = userService.getAllFavoritesByUsername(userRequest.getUsername());
        return new ResponseEntity<List<Favorite>>(favorites, HttpStatus.OK);
    }
}
