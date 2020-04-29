package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
* When creating user, favorites data member must be null.
* New favorite must be added only from /favorite/add.
*/
public class FavoritesNotNullException extends RuntimeException {
    @ControllerAdvice
    static class FavoriteNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(FavoritesNotNullException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String favoritesNotNullHandler(FavoritesNotNullException ex) {
            return ex.getMessage();
        }

    }

    public FavoritesNotNullException() {
        super("It is not allowed to create favorites at the user creation. Please add favorite via favortie/add path.");
    }
}
