package com.busService.dtos.requests.DriverRequests;


import lombok.Data;

@Data
public class DeleteDriverRequest {
    private String driverEmail;
    private String driverName;
}
