package com.busService.dtos.requests;

import lombok.Data;

@Data
public class RegisterPassengerRequest {
    private String name;
    private String email;
    private String phone;
    private String password;
}
