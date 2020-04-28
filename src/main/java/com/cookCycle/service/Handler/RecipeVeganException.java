package com.cookCycle.service.Handler;

import com.cookCycle.model.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RecipeVeganException extends RuntimeException {
    @ControllerAdvice
    static class RecipeNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(RecipeVeganException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String recipeVeganHandler(RecipeVeganException ex) {
            return ex.getMessage();
        }

    }

    public RecipeVeganException(Recipe recipe) {
        super("Vegan recipe must be vegetarian and dairy free.");
    }
}
