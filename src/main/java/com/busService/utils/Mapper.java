package com.busService.utils;

import com.busService.datas.models.Bus;
import com.busService.dtos.requests.RegisterBusRequest;
import com.busService.dtos.responses.RegisterBusResponse;

public class Mapper {

    public static Bus mapToRegisterBus(RegisterBusRequest busRequest) {
        Bus newBus = new Bus();
        newBus.setName(busRequest.getName().trim().toUpperCase());
        newBus.setModel(busRequest.getModel().trim().toUpperCase());
        newBus.setColor(busRequest.getColor().trim().toUpperCase());
        newBus.setChasisNumber(busRequest.getChasisNumber().trim().toUpperCase());
        newBus.setYear(busRequest.getYear());
        newBus.setCapacity(busRequest.getCapacity());
        newBus.setPlateNumber(busRequest.getPlateNumber().toUpperCase());

        return newBus;
    }

    public static RegisterBusResponse mapToRegisterBusResponse(Bus response) {
        RegisterBusResponse registerBusResponse = new RegisterBusResponse();
        registerBusResponse.setId(response.getId());
        registerBusResponse.setYear(response.getYear());
        String busDetails = (response.getName() + " " + response.getModel() + " " + response.getColor() + " " + response.getChasisNumber() + " " + response.getPlateNumber());
        registerBusResponse.setBusDetails(busDetails);
        registerBusResponse.setCapacity(response.getCapacity());
        boolean isAvailable = true;
        registerBusResponse.setAvailable(isAvailable);

        return registerBusResponse;
    }
}
