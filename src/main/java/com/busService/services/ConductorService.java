package com.busService.services;

import com.busService.dtos.requests.conductorRequests.*;
import com.busService.dtos.responses.ConductorResponses.*;

public interface ConductorService {
    RegisterConductorResponse registerConductor(RegisterConductorRequest request);
    EditConductorFullNameResponse changeFullName(EditConductorFullNameRequest request);
    EditConductorPasswordResponse changePassword(EditConductorPasswordRequest request);
    EditConductorAgeResponse changeAge(EditConductorAgeRequest request);
    EditConductorPhoneNumberResponse changePhoneNumber(EditConductorPhoneNumberRequest request);
    DeleteConductorResponse deleteConductor(DeleteConductorRequest request);
    ViewConductorProfileResponse viewProfile(String phoneNumber);
}
