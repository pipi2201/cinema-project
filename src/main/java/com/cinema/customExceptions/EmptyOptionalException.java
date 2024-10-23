package com.cinema.customExceptions;

public class EmptyOptionalException extends RuntimeException {

    public EmptyOptionalException(String message) {
        super(message);
    }
}
