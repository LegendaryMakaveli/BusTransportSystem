package com.busService.dtos.responses.ConductorResponses;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class EditConductorPhoneNumberResponse {
    private String response;
    private String id;
    private String phoneNumber;
    private LocalDateTime editConductorAgeAt;
}
