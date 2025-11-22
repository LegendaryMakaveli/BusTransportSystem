package com.busService.dtos.responses.DriverResponses;

import com.busService.datas.models.Gender;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterDriverResponse {
    private String id;
    private String driverDetails; //todo driverEmail, driverHeight, driverAge, driverPhone, driverLicenseNumber
    private Gender gender;
    private boolean active;
    private LocalDateTime registerDate;
}
