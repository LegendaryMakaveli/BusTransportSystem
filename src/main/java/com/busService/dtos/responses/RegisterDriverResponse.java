package com.busService.dtos.responses;

import com.busService.datas.models.Gender;
import lombok.Data;

@Data
public class RegisterDriverResponse {
    private String id;
    private String driverDetails; //todo driverEmail, driverHeight, driverAge, driverPhone, driverLicenseNumber
    private Gender gender;
}
