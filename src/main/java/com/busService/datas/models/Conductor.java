package com.busService.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Conductor")
public class Conductor {
    @Id
    private String id;
    private String name;
    private int age;
    private Gender gender;
    private String phone;
    private String password;
    private boolean isActive;
    private LocalDateTime conductorRegistrationDate;
}
