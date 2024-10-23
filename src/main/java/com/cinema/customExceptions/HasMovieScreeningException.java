package com.cinema.customExceptions;

public class hasMovieScreeningException extends RuntimeException {
    public hasMovieScreeningException(String message) {
        super(message);
    }
}
