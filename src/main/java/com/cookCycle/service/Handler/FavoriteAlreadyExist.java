package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FavoriteAlreadyExist extends RuntimeException {
    @ControllerAdvice
    static class FavoriteNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(FavoriteAlreadyExist.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String favoriteNotFoundHandler(FavoriteAlreadyExist ex) {
            return ex.getMessage();
        }

    }

    public FavoriteAlreadyExist() {
        super("This recipe already a favorite of this user.");
    }
}
