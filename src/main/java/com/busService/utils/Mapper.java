package com.busService.utils;

import com.busService.datas.models.Bus;
import com.busService.datas.models.Conductor;
import com.busService.datas.models.Gender;
import com.busService.dtos.requests.RegisterBusRequest;
import com.busService.dtos.requests.conductorRequests.*;
import com.busService.dtos.responses.ConductorResponses.*;
import com.busService.dtos.responses.RegisterBusResponse;

import java.time.LocalDateTime;

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

    public static Conductor mapToRegisterConductor(RegisterConductorRequest request) {
        Conductor newConductor = new Conductor();
        newConductor.setName(request.getName().trim().toUpperCase());
        newConductor.setAge(request.getAge());
        newConductor.setGender(Gender.valueOf(request.getGender().trim().toUpperCase()));
        newConductor.setPhone(request.getPhone().trim());
        newConductor.setPassword(request.getPassword().trim().toUpperCase());

        return newConductor;
    }

    public static RegisterConductorResponse mapToRegisterConductorResponse(Conductor response) {
        RegisterConductorResponse conductorResponse = new RegisterConductorResponse();
        conductorResponse.setId(response.getId());
        conductorResponse.setConductorGender(response.getGender());
        conductorResponse.setConductorDetails(response.getName() + " " + response.getAge() + " " + response.getPhone());
        boolean isAvailable = true;
        conductorResponse.setActive(isAvailable);
        conductorResponse.setApplicationDate(LocalDateTime.now());

        return conductorResponse;
    }

    public static void mapToUpdateConductorName(Conductor conductor, EditConductorFullNameRequest request) {
        conductor.setPhone(request.getConductorPhoneNumber().trim());
        conductor.setName(request.getConductorNewFullName().trim().toUpperCase());
    }


    public static EditConductorFullNameResponse mapToEditConductorFullNameReponse(Conductor response){
        EditConductorFullNameResponse conductorResponse = new EditConductorFullNameResponse();
        conductorResponse.setResponse("Full Name Updated Successfully");
        conductorResponse.setId(response.getId());
        conductorResponse.setConductorFullName(response.getName());
        conductorResponse.setEditConductorFullNameAt(  response.getConductorRegistrationDate());
        return conductorResponse;
    }


    public static void mapToUpdateConductorPassword(Conductor conductor, EditConductorPasswordRequest request) {
        conductor.setPhone(request.getConductorPhoneNumber().trim());
        conductor.setPassword(request.getConductorPassword().trim().toUpperCase());
    }

    public static EditConductorPasswordResponse mapToEditConductorPasswordResponse(Conductor response){
        EditConductorPasswordResponse conductorResponse = new EditConductorPasswordResponse();
        conductorResponse.setResponse("Password Updated Successfully");
        conductorResponse.setId(response.getId());
        conductorResponse.setEditConductorPasswordAt(  response.getConductorRegistrationDate());
        return conductorResponse;
    }


    public static void mapToUpdateConductorAge(Conductor conductor, EditConductorAgeRequest request) {
        conductor.setPhone(request.getConductorPhoneNumber().trim());
        conductor.setAge(request.getAge());
    }

    public static EditConductorAgeResponse mapToEditConductorAgeResponse(Conductor response){
        EditConductorAgeResponse conductorResponse = new EditConductorAgeResponse();
        conductorResponse.setResponse("Age Updated Successfully");
        conductorResponse.setId(response.getId());
        conductorResponse.setAge(response.getAge());
        conductorResponse.setEditConductorAgeAt(  response.getConductorRegistrationDate());
        return conductorResponse;
    }


    public static void mapToUpdateConductorPhoneNumber(Conductor conductor, EditConductorPhoneNumberRequest request) {
        conductor.setPhone(request.getConductorPhoneNumber().trim());
        conductor.setPhone(request.getConductorNewPhoneNumber().trim());
    }

    public static EditConductorPhoneNumberResponse mapToEditConductorPhoneNumberResponse(Conductor response){
        EditConductorPhoneNumberResponse conductorResponse = new EditConductorPhoneNumberResponse();
        conductorResponse.setResponse("Phone Number Updated Successfully");
        conductorResponse.setId(response.getId());
        conductorResponse.setPhoneNumber(response.getPhone());
        conductorResponse.setEditConductorAgeAt(  response.getConductorRegistrationDate());
        return conductorResponse;
    }

    public static DeleteConductorResponse mapToDeleteConductorResponse(Conductor response){
        DeleteConductorResponse conductorResponse = new DeleteConductorResponse();
        conductorResponse.setGoodByeMessage("Ehya!!! Goodbye ooo ");
        return conductorResponse;
    }

    public static ViewConductorProfileResponse mapToViewConductorResponse(Conductor conductor) {
        ViewConductorProfileResponse response = new ViewConductorProfileResponse();
        response.setName(conductor.getName());
        response.setPhone(conductor.getPhone());
        response.setAge(conductor.getAge());
        response.setId(conductor.getId());
        response.setGender(conductor.getGender());
        response.setActive(true);


        return response;
    }

}
