package com.codingkraken.TodoApp.exception;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

public class TodoNotFoundException extends RuntimeJsonMappingException {

    public TodoNotFoundException(String message) {
        super(message);
    }

}
