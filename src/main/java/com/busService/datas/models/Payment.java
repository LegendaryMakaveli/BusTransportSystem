package com.busService.datas.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Payments")
public class Payment {
    private String id;
    private String ticketId;
    private double amount;
    private String method;
    private LocalDateTime transactionDate;
}
