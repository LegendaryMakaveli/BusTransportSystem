package com.busService.utils;

import com.busService.datas.models.Driver;
import com.busService.datas.models.Gender;
import com.busService.datas.models.Roles;
import com.busService.dtos.requests.DriverRequests.RegisterDriverRequest;
import com.busService.dtos.responses.DriverResponses.RegisterDriverResponse;

import java.time.LocalDateTime;


public class DriverMapper {
    public static Driver mapToRegisterDriver(RegisterDriverRequest request) {
        Driver newDriver = new Driver();
        newDriver.setRole(Roles.valueOf(request.getRoles().trim().toUpperCase()));
        newDriver.setName(request.getName().trim().toUpperCase());
        newDriver.setEmail(request.getEmail().trim().toUpperCase());
        newDriver.setAge(request.getAge());
        newDriver.setHeight(request.getHeight());
        newDriver.setLicenseNumber(request.getLicenseNumber().trim().toUpperCase());
        newDriver.setPhone(request.getPhone());
        newDriver.setGender(Gender.valueOf(request.getGender().trim().toUpperCase()));
        return newDriver;
    }

    public static RegisterDriverResponse mapToRegisterDriverResponse(Driver response) {
        RegisterDriverResponse driverResponse = new RegisterDriverResponse();
        driverResponse.setId(response.getId());
        driverResponse.setGender(response.getGender());
        String busDetails = (response.getName() + " " + response.getAge() + " " + response.getEmail() + " " + response.getPhone() + " " + response.getLicenseNumber());
        driverResponse.setDriverDetails(busDetails);
        driverResponse.setActive(true);
        driverResponse.setRegisterDate(LocalDateTime.now());

        return driverResponse;
    }
}
