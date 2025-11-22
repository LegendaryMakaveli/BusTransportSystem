package com.busService.dtos.responses.ConductorResponses;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class EditConductorAgeResponse {
    private String response;
    private int age;
    private String id;
    private LocalDateTime editConductorAgeAt;
}
