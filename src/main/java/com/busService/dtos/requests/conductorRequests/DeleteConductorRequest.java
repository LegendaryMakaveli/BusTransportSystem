package com.busService.dtos.requests.conductorRequests;


import lombok.Data;

@Data
public class DeleteConductorRequest {
    private String conductorPhoneNumber;
    private String conductorName;
}
