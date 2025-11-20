package com.busService.datas.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Drivers")
public class Driver {
    @Id
    private String id;
    private String name;
    private String email;
    private String licenseNumber;
    private double height;
    private int age;
    private Gender gender;
    private String phone;
    private Roles role;
    private String password;
    private boolean active;
}
