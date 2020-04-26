package com.cookCycle.service.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserAlreadyExist extends RuntimeException {
    @ControllerAdvice
    static class UserNotFoundHandler {

        @ResponseBody
        @ExceptionHandler(UserAlreadyExist.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String userNotFoundHandler(UserAlreadyExist ex) {
            return ex.getMessage();
        }

    }

    public UserAlreadyExist(String similarUsername) {
        super("This username already exist: " + similarUsername);
    }
}
