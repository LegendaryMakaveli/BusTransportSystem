package com.busService.dtos.responses.ConductorResponses;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class EditConductorPasswordResponse {
    private String response;
    private String id;
    private LocalDateTime editConductorPasswordAt;
}
