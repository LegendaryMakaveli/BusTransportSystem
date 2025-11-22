package com.busService.dtos.responses.DriverResponses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EditDriverPhoneNumberResponse {
    private String response;
    private String id;
    private String phoneNumber;
    private LocalDateTime editConductorAgeAt;
}
