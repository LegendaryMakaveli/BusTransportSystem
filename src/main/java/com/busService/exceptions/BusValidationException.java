package com.busService.exceptions;

public class BusValidationException extends RuntimeException {
    public BusValidationException(String message) {
        super(message);
    }
}
