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
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/add/{username}").buildAndExpand(user.getUsername()).toUri());
        return new ResponseEntity<User>(dbUser, HttpStatus.CREATED);
    }

    @PostMapping(path = "/getallfavoritesbyusername") // post request because username is an email so it must be sent within the body of the request.
    public ResponseEntity<List<Favorite>> getAllFavoritesByUsername(@RequestBody User userRequest) {
        List<Favorite> favorites = userService.getAllFavoritesByUsername(userRequest.getUsername());
        return new ResponseEntity<List<Favorite>>(favorites, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateArticle(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
