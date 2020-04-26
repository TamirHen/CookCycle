package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FavoriteNotFoundException extends RuntimeException {
    @ControllerAdvice
    static class FavoriteNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(FavoriteNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String favoriteNotFoundHandler(FavoriteNotFoundException ex) {
            return ex.getMessage();
        }

    }

    public FavoriteNotFoundException(Long id) {
        super("No Favorite with id: " + id);
    }
}
