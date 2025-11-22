package com.busService.dtos.requests.conductorRequests;

import lombok.Data;

@Data
public class RegisterConductorRequest {
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String password;
}
