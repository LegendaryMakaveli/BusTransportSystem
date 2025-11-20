package com.busService.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MaintenanceBusResponse {
    private String id;
    private String busDetailsInMaintenance; //todo busName, busModel, busYear, busPlateNumber
    private boolean acknowledged;
    private LocalDateTime maintenanceDate;
}
