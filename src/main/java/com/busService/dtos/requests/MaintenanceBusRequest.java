package com.busService.dtos.requests;


import lombok.Data;

@Data
public class MaintainBusRequest {
    private String id;
    private String name;
    private String model;
    private String year;
    private String plateNumber;
    private String chasisNumber;
}
