package com.busService.dtos.requests;

import com.busService.datas.models.Gender;
import lombok.Data;

@Data
public class AssignConductorToDriverRequest {
    private String conductorName;
    private String id;
    private Gender gender;
}
