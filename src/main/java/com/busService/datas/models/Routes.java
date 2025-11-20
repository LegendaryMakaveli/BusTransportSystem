package com.busService.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Routes")
public class Routes {
    @Id
    private String id;
    private String startLocation;
    private String endLocation;
    private double distance;
    private String estimatedDuration;
    private List<Trip> trips = new ArrayList<>();
}
