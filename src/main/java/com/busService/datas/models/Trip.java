package com.busService.datas.models;


import lombok.Data;

@Data
public class Trip {
    private String id;
    private String busId;
    private String routeId;
    private String driverId;
    private String conductorId;
    private String departureTime;
    private String arrivalTime;
    private String status;
}
