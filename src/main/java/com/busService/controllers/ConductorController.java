package com.busService.controllers;

import com.busService.dtos.requests.conductorRequests.*;
import com.busService.dtos.responses.ConductorResponses.*;
import com.busService.services.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConductorController {
    @Autowired
    private ConductorService conductorService;

    @PostMapping( "/conductor/register")
    public RegisterConductorResponse registerConductor(@RequestBody RegisterConductorRequest request) {
        return conductorService.registerConductor(request);
    }

    @PostMapping( "/conductor/updateFullName")
    public EditConductorFullNameResponse editFullName(@RequestBody EditConductorFullNameRequest request) {
        return conductorService.changeFullName(request);
    }

    @PostMapping( "/conductor/updatePassword")
    public EditConductorPasswordResponse editPassword(@RequestBody EditConductorPasswordRequest request) {
        return conductorService.changePassword(request);
    }

    @PostMapping( "/conductor/updateAge")
    public EditConductorAgeResponse editAge(@RequestBody EditConductorAgeRequest request) {
        return conductorService.changeAge(request);
    }

    @PostMapping( "/conductor/updatePhoneNumber")
    public EditConductorPhoneNumberResponse editPhoneNumber(@RequestBody EditConductorPhoneNumberRequest request) {
        return conductorService.changePhoneNumber(request);
    }

    @PostMapping( "/conductor/delete")
    public DeleteConductorResponse deleteConductor(@RequestBody DeleteConductorRequest request) {
        return conductorService.deleteConductor(request);
    }

    @GetMapping( "/conductor/{phone}")
    public ViewConductorProfileResponse viewProfile(@PathVariable String phone) {
        return conductorService.viewProfile(phone);
    }

}
