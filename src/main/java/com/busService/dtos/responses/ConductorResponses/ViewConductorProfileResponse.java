package com.busService.dtos.responses.ConductorResponses;

import com.busService.datas.models.Gender;
import lombok.Data;


@Data
public class ViewConductorProfileResponse {
    private String id;
    private String name;
    private int age;
    private Gender gender;
    private String phone;
    private boolean isActive;
}
