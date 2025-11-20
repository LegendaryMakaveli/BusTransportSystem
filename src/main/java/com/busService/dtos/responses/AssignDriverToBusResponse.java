package com.busService.dtos.responses;

import com.busService.datas.models.Bus;
import lombok.Data;

@Data
public class AssignDriverToBusResponse {
    private String id;
    private String name;
    private String email;
}
