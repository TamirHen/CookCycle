package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends RuntimeException {
    @ControllerAdvice
    static class UserNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(UserNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String userNotFoundHandler(UserNotFoundException ex) {
            return ex.getMessage();
        }

    }

    public UserNotFoundException(String username) {
        super("No User with username: " + username);
    }
}
