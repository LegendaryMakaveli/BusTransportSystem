package com.busService.dtos.requests.conductorRequests;


import lombok.Data;

@Data
public class EditConductorAgeRequest {
    private String conductorPhoneNumber;
    private int age;
}
