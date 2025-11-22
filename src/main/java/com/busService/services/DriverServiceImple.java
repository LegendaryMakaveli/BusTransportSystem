package com.busService.services;

import com.busService.datas.models.Driver;
import com.busService.datas.models.Roles;
import com.busService.datas.repositories.DriverRepository;
import com.busService.dtos.requests.DriverRequests.RegisterDriverRequest;
import com.busService.dtos.responses.DriverResponses.RegisterDriverResponse;
import com.busService.exceptions.BusAlreadyExist;
import com.busService.exceptions.DriverNotFoundException;
import com.busService.exceptions.DriverValidationException;
import com.busService.exceptions.InvalidRoleException;
import com.mongodb.DuplicateKeyException;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.busService.utils.DriverMapper.mapToRegisterDriver;
import static com.busService.utils.DriverMapper.mapToRegisterDriverResponse;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class DriverServiceImple implements DriverService{
    @Autowired
    private DriverRepository driverRepository;


    @Override
    public RegisterDriverResponse registerDriver(RegisterDriverRequest request) {
        validateDriverRole(request);
        validateDriverInputOne(request);
        validateDriverInputTwo(request);
        validateDriverInputThree(request);

        Driver newDriver = mapToRegisterDriver(request);
        newDriver.setRegisterDriverAt(LocalDateTime.now());

        try {
            Driver savedDriver = driverRepository.save(newDriver);
            return mapToRegisterDriverResponse(savedDriver);

        } catch (DuplicateKeyException e) {
            throw new BusAlreadyExist("Driver with email number '" + request.getEmail() + "' already exists");

        } catch (Exception e) {
            throw new DriverNotFoundException("Failed to register driver: " + e.getMessage());
        }
    }





    private static void validateDriverInputOne(RegisterDriverRequest request){
        if(request.getName() == null || request.getName().trim().isEmpty())throw new DriverValidationException("Name cannot be Empty");
        if(request.getName().length() < 4)throw new DriverValidationException("Name length cannot be less than 4");
        if(request.getPhone().length() < 11)throw new DriverValidationException("Phone length cannot be less than 11");
        if(request.getPhone().length() > 11)throw new DriverValidationException("Phone length cannot be more than 11");
        if(request.getEmail() == null || request.getEmail().trim().isEmpty())throw new DriverValidationException("Email cannot be Empty");
    }
    private static void validateDriverInputTwo(RegisterDriverRequest request){
        if(request.getAge() > 50)throw new DriverValidationException("Age cannot be greater than 50");
        if(request.getAge() < 18)throw new DriverValidationException("Age cannot be less than 18");
        if(request.getLicenseNumber() == null || request.getLicenseNumber().trim().isEmpty())throw new DriverValidationException("License number cannot be Empty");
        if(request.getLicenseNumber().length() < 12 || request.getLicenseNumber().length() > 12)throw new DriverValidationException("License number is not correct");
        if(request.getHeight() < 4.5)throw new DriverValidationException("you are too short");
    }
    private static void validateDriverInputThree(RegisterDriverRequest request){
        if(request.getHeight() > 7.5)throw new DriverValidationException("You are too tall");
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(!request.getEmail().matches(emailPattern))throw new DriverValidationException("Invalid Email");
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[^\\s]{6,15}$";
        if(!request.getPassword().matches(passwordPattern))throw new DriverValidationException("Passwords do not match");
    }
    private void validateDriverRole(RegisterDriverRequest request) {
        try {
            Roles role = Roles.valueOf(request.getRoles().trim().toUpperCase());
            if (role != Roles.DRIVER)throw new InvalidRoleException("Only users with DRIVER role can register on this page");

        } catch (IllegalArgumentException | NullPointerException e) {
            throw new InvalidRoleException("Invalid role");
        }
    }

}
