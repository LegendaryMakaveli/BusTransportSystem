package com.busService.services;

import com.busService.dtos.requests.RegisterBusRequest;
import com.busService.dtos.responses.RegisterBusResponse;

public interface BusServices {
    RegisterBusResponse registerBus(RegisterBusRequest Request);
}
