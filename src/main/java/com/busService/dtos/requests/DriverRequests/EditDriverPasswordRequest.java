package com.busService.dtos.requests.DriverRequests;


import lombok.Data;

@Data
public class EditDriverPasswordRequest {
    private String driverEmail;
    private String newPassword;
}
