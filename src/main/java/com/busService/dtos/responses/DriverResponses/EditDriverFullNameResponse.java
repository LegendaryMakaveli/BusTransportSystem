package com.busService.dtos.responses.DriverResponses;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class EditDriverFullNameResponse {
    private String response;
    private String conductorFullName;
    private String id;
    private LocalDateTime editConductorFullNameAt;
}
