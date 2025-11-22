package com.busService.dtos.requests.DriverRequests;


import lombok.Data;


@Data
public class AssignDriverToBusRequest {
    private String name;
    private String email;
    private String licenseNumber;
    private double height;
}
