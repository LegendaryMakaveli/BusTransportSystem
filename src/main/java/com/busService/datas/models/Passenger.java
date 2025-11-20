package com.busService.datas.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Passengers")
public class Passenger {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
