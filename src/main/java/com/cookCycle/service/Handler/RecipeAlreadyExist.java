package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RecipeAlreadyExist extends RuntimeException {
    @ControllerAdvice
    static class RecipeNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(RecipeAlreadyExist.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String recipeNotFoundHandler(RecipeAlreadyExist ex) {
            return ex.getMessage();
        }

    }

    public RecipeAlreadyExist(Long similarId) {
        super("This apiId already exist. similar recipeId: " + similarId);
    }
}
