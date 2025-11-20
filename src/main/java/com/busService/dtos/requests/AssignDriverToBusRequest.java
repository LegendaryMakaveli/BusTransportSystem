package com.busService.dtos.requests;


import lombok.Data;


@Data
public class AssignDriverToBusRequest {
    private String name;
    private String email;
    private String licenseNumber;
    private double height;
}
