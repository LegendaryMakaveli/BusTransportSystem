package com.busService.dtos.responses.ConductorResponses;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EditConductorFullNameResponse {
    private String response;
    private String conductorFullName;
    private String id;
    private LocalDateTime editConductorFullNameAt;
}
