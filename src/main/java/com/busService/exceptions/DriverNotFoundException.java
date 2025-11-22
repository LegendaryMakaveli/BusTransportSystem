package com.busService.exceptions;

public class DriverNotFoundException extends BusSystemException{
    public DriverNotFoundException(String message) {
        super(message);
    }
}
