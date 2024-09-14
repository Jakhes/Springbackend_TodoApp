package com.codingkraken.TodoApp.exception;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

public class UserNotFoundException extends RuntimeJsonMappingException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
