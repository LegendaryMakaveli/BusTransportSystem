package com.busService.datas.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Maintenances")
public class Maintance {
    @Id
    private String id;
    private String busId;
    private String busName;
    private String busModel;
    private String driverId;
    private String description;
    private double cost;
    private LocalDateTime dateOfMaintainance;
}

