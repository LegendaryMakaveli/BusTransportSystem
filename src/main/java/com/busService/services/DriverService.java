package com.busService.services;

import com.busService.dtos.requests.DriverRequests.RegisterDriverRequest;
import com.busService.dtos.responses.DriverResponses.RegisterDriverResponse;

public interface DriverService {
    RegisterDriverResponse registerDriver(RegisterDriverRequest request);
}
