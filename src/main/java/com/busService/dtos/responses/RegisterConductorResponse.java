package com.busService.dtos.responses;

import com.busService.datas.models.Gender;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterConductorResponse {
    private String id;
    private String conductorDetails; //todo conductorName, conductorAge, conductorPhone
    private Gender conductorGender;
    private boolean isActive;
    private LocalDateTime applicationDate;
}
