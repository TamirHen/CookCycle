package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RecipeCategoryNotFoundException extends RuntimeException {
    @ControllerAdvice
    static class RecipeNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(RecipeCategoryNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String recipeCategoryNotFoundHandler(RecipeCategoryNotFoundException ex) {
            return ex.getMessage();
        }

    }

    public RecipeCategoryNotFoundException(Long id) {
        super("No RecipeCategory with id: " + id);
    }
}
