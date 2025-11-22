package com.busService.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "Buses")
public class Bus {
    @Id
    private String id;
    private String name;
    private String model;
    private String color;
    private int year;
    private String plateNumber;
    private String chasisNumber;
    private int capacity;
    private String assignedDriverId;
    private String assignedConductorId;
    private String status;
    private LocalDateTime registerBusAt;
}
