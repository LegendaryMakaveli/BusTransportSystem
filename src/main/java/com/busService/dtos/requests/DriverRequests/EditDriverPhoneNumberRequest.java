package com.busService.dtos.requests.DriverRequests;


import lombok.Data;

@Data
public class EditDriverPhoneNumberRequest {
    private String driverEmail;
    private String phoneNumber;
}
