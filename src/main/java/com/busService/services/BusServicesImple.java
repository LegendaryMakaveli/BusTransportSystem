package com.busService.services;

import com.busService.datas.models.Bus;
import com.busService.datas.repositories.BusRepositories;
import com.busService.dtos.requests.RegisterBusRequest;
import com.busService.dtos.responses.RegisterBusResponse;
import com.busService.exceptions.BusAlreadyExist;
import com.busService.exceptions.BusValidationException;
import com.mongodb.DuplicateKeyException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.busService.utils.Mapper.mapToRegisterBus;
import static com.busService.utils.Mapper.mapToRegisterBusResponse;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class BusServicesImple implements BusServices {
    @Autowired
    private BusRepositories busRepositories;



    @Override
    public RegisterBusResponse registerBus(RegisterBusRequest request) {
       validateBusInput(request);
        Bus newBus = mapToRegisterBus(request);
        newBus.setRegisterBusAt(LocalDateTime.now());

        try {
            Bus savedBus = busRepositories.save(newBus);
            return mapToRegisterBusResponse(savedBus);

        } catch (DuplicateKeyException e) {
            throw new BusAlreadyExist(
                    "A bus with chassis number '" + request.getChasisNumber() + "' already exists"
            );

        } catch (Exception e) {
            throw new BusAlreadyExist("Failed to register bus: " + e.getMessage());
        }
    }















































    private void validateBusInput(RegisterBusRequest request) {
        if(request.getChasisNumber().length() < 11)throw new BusValidationException("Chasis Number Not Correct");
        if(request.getChasisNumber() == null || request.getChasisNumber().trim().isEmpty())throw new BusValidationException("Chasis Number Empty");
        if(request.getCapacity() == 0)throw new BusValidationException("Bus Capacity cannot be 0");
        if(request.getColor() == null || request.getColor().trim().isEmpty())throw new BusValidationException("Bus Color cannot be Empty");
        if(request.getName() == null || request.getName().trim().isEmpty())throw new BusValidationException("Bus Name cannot be Empty");
        if(request.getModel() == null || request.getModel().trim().isEmpty())throw new BusValidationException("Bus Model cannot be Empty");
        if(request.getPlateNumber() == null || request.getPlateNumber().trim().isEmpty())throw new BusValidationException("Bus Plate Number cannot be Empty");
        if(request.getYear() == 0)throw new BusValidationException("Bus Year cannot be 0");
    }
}
