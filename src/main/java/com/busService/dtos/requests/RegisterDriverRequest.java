package com.busService.dtos.requests;

import com.busService.datas.models.Gender;
import lombok.Data;

@Data
public class RegisterDriverRequest {
    private String name;
    private String email;
    private String licenseNumber;
    private double height;
    private int age;
    private Gender gender;
    private String phone;
    private String password;
}
