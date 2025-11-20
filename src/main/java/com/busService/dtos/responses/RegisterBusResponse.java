package com.busService.dtos.responses;


import lombok.Data;

@Data
public class RegisterBusResponse {
    private String id;
    private String busDetails; //todo--> busName, busModel,busYear,busColor, busPlateNumber,busChasisNumber
    private int capacity;
    private boolean isAvailable;
}
