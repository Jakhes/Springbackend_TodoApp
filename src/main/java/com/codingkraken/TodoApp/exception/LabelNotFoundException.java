package com.codingkraken.TodoApp.exception;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

public class LabelNotFoundException extends RuntimeJsonMappingException {

    public LabelNotFoundException(String message) {
        super(message);
    }

}