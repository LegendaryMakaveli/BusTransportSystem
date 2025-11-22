package com.busService.dtos.responses.DriverResponses;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class EditDriverPasswordResponse {
    private String response;
    private String id;
    private LocalDateTime editConductorPasswordAt;
}
