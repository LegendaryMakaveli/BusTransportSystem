package com.busService.dtos.requests.conductorRequests;


import lombok.Data;

@Data
public class EditConductorPhoneNumberRequest {
    private String conductorPhoneNumber;
    private String conductorNewPhoneNumber;
}
