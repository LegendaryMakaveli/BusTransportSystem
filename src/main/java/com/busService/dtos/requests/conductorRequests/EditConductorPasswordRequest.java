package com.busService.dtos.requests.conductorRequests;

import lombok.Data;

@Data
public class EditConductorPasswordRequest {
    private String conductorPhoneNumber;
    private String conductorPassword;
}
