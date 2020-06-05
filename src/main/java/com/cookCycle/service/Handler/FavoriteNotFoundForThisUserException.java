package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FavoriteNotFoundForThisUserException extends RuntimeException {
    @ControllerAdvice
    static class FavoriteNotFoundForThisUserHandler {

        @ResponseBody
        @ExceptionHandler(FavoriteNotFoundForThisUserException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String favoriteNotFoundForThisUserHandler(FavoriteNotFoundForThisUserException ex) {
            return ex.getMessage();
        }

    }

    public FavoriteNotFoundForThisUserException(String username, Long recipeId) {
        super("No favorite with id: " + recipeId + " found for user: " + username);
    }
}
