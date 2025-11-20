package com.busService.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Buses")
public class Bus {
    @Id
    private String id;
    private String model;
    private String plateNumber;
    private String chasisNumber;
    private int capacity;
    private String assignedDriverId;
    private String assignedConductorId;
    private String status;
}
