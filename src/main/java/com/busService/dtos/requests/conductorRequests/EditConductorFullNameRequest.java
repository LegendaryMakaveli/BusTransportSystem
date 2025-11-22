package com.busService.dtos.requests.conductorRequests;


import lombok.Data;

@Data
public class EditConductorFullNameRequest {
    private String conductorPhoneNumber;
    private String conductorNewFullName;
}
