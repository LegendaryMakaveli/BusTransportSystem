package com.busService.dtos.requests;

import com.busService.datas.models.Gender;
import lombok.Data;

@Data
public class RegisterConductorRequest {
    private String name;
    private int age;
    private Gender gender;
    private String phone;
    private String password;
}
