package com.busService.controllers;

import com.busService.dtos.requests.RegisterBusRequest;
import com.busService.dtos.responses.RegisterBusResponse;
import com.busService.services.BusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {
    @Autowired
    private BusServices busServices;


    @PostMapping( "/bus/register")
    public RegisterBusResponse registerBus(@RequestBody RegisterBusRequest request) {
        return busServices.registerBus(request);
    }
}
