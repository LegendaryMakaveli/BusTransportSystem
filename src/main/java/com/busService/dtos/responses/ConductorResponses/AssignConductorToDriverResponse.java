package com.busService.dtos.responses.ConductorResponses;

import com.busService.datas.models.Gender;
import lombok.Data;


@Data
public class AssignConductorToDriverResponse {
    private String conductorName;
    private String id;
    private Gender gender;
}
