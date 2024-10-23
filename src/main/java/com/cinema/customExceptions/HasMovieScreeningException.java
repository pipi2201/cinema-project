package com.cinema.customExceptions;

public class HasMovieScreeningException extends RuntimeException {

    public HasMovieScreeningException(String message) {
        super(message);
    }
}
