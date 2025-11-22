package com.busService.dtos.requests.DriverRequests;


import lombok.Data;

@Data
public class EditDriverAgeRequest {
    private String driverEmail;
    private int newAge;
}
