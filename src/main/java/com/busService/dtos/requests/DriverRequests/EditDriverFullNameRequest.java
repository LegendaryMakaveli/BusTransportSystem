package com.busService.dtos.requests.DriverRequests;


import lombok.Data;

@Data
public class EditDriverFullNameRequest {
    private String driverEmail;
    private String driverNewFullName;
}
