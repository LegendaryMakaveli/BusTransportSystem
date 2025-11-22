package com.busService.exceptions;

public class BusNotFoundException extends BusSystemException{
    public BusNotFoundException(String message) {
        super(message);
    }
}
