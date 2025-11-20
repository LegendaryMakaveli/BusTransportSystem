package com.busService.datas.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Tickets")
public class Ticket {
    @Id
    private String id;
    private String tripId;
    private String passengerId;
    private int seatNumber;
    private double price;
    private String paymentStatus;
}
