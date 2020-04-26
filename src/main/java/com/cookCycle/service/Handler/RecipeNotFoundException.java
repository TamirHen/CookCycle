package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RecipeNotFoundException extends RuntimeException {
    @ControllerAdvice
    static class RecipeNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(RecipeNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String recipeNotFoundHandler(RecipeNotFoundException ex) {
            return ex.getMessage();
        }

    }

    public RecipeNotFoundException(Long id) {
        super("No Recipe with id: " + id);
    }
}
