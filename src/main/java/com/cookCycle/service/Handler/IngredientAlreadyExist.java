package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class IngredientAlreadyExist extends RuntimeException {
    @ControllerAdvice
    static class IngredientNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(IngredientAlreadyExist.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String ingredientNotFoundHandler(IngredientAlreadyExist ex) {
            return ex.getMessage();
        }

    }

    public IngredientAlreadyExist(Long similarId) {
        super("This apiId already exist. similar ingredientId: " + similarId);
    }
}
