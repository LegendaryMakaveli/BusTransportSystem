package com.busService.dtos.responses.ConductorResponses;

import com.busService.datas.models.Gender;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterConductorResponse {
    private String id;
    private String conductorDetails;
    private Gender conductorGender;
    private boolean isActive;
    private LocalDateTime applicationDate;
}
