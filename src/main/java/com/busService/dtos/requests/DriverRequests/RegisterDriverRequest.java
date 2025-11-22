package com.busService.dtos.requests.DriverRequests;

import com.busService.datas.models.Gender;
import com.busService.datas.models.Roles;
import lombok.Data;

@Data
public class RegisterDriverRequest {
    private String name;
    private String email;
    private String licenseNumber;
    private double height;
    private int age;
    private String roles;
    private String gender;
    private String phone;
    private String password;
}
