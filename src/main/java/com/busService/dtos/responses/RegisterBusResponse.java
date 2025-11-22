package com.busService.dtos.responses;


import lombok.Data;

@Data
public class RegisterBusResponse {
    private String id;
    private String busDetails;
    private int year;
    private int capacity;
    private boolean isAvailable;
}
