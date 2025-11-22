package com.busService.exceptions;

public class UserAlreadyExistException extends BusSystemException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
