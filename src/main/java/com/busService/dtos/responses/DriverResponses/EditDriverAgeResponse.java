package com.busService.dtos.responses.DriverResponses;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class EditDriverAgeResponse {
    private String response;
    private int age;
    private String id;
    private LocalDateTime editConductorAgeAt;
}
