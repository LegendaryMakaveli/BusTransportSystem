package com.busService.datas.models;

public enum Roles {
    CEO("The Owner of the company", 10_000_000),
    DRIVER("The driver of a bus and an employee of the company", 200_000),
    CONDUCTOR("An employee that is in conduct of getting passenger into the bus", 90_000),
    ACCOUNTANT("An employee in charge of accounting", 150_000),
    MANAGER("Transport manager", 250_000),
    PASSENGER("Customer to the company", 0);


    private final String description;
    private final int salary;

    Roles(String description, int salary) {
        this.description = description;
        this.salary = salary;
    }
}
