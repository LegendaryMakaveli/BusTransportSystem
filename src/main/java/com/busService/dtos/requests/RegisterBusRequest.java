package com.busService.dtos.requests;


import lombok.Data;

@Data
public class RegisterBusRequest {
    private String name;
    private String model;
    private String color;
    private String year;
    private String plateNumber;
    private String chasisNumber;
    private int capacity;
}
