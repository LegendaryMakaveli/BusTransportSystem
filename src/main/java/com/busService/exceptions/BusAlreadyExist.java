package com.busService.exceptions;

public class BusAlreadyExist extends RuntimeException {
    public BusAlreadyExist(String message) {
        super(message);
    }
}
