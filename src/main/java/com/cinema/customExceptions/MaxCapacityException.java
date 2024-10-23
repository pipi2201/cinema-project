package com.cinema.customExceptions;

public class MaxCapacityException extends RuntimeException {
    public MaxCapacityException(String message) {
        super(message);
    }
}
