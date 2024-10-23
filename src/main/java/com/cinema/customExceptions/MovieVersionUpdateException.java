package com.cinema.customExceptions;

public class MovieVersionUpdateException extends RuntimeException {
    public MovieVersionUpdateException(String message) {
        super(message);
    }
}
