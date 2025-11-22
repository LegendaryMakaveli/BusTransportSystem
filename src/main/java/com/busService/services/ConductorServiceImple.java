package com.busService.services;

import com.busService.datas.models.Conductor;
import com.busService.datas.repositories.ConductorRepository;
import com.busService.dtos.requests.conductorRequests.*;
import com.busService.dtos.responses.ConductorResponses.*;
import com.busService.exceptions.UserAlreadyExistException;
import com.busService.exceptions.conductorInputValidationException;
import com.mongodb.DuplicateKeyException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.busService.utils.Mapper.*;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ConductorServiceImple implements ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;


    @Override
    public RegisterConductorResponse registerConductor(RegisterConductorRequest request) {
        validateConductorInput(request);

        Conductor newConductor = mapToRegisterConductor(request);
        newConductor.setConductorRegistrationDate(LocalDateTime.now());

        try {
            Conductor savedConductor = conductorRepository.save(newConductor);
            return mapToRegisterConductorResponse(savedConductor);

        }catch (DuplicateKeyException e) {
            throw new UserAlreadyExistException("User already exists");

        }catch (Exception e) {
            throw new UserAlreadyExistException("User already exists");
        }

    }

    @Override
    public EditConductorFullNameResponse changeFullName(EditConductorFullNameRequest request) {
        validateUpdateFullName(request);
        Conductor conductor = conductorRepository.findByPhone(request.getConductorPhoneNumber()).orElseThrow(() -> new conductorInputValidationException("Conductor not found with phone number"));
        mapToUpdateConductorName(conductor, request);

         Conductor savedEdit = conductorRepository.save(conductor);

        return mapToEditConductorFullNameReponse(savedEdit);
    }


    @Override
    public EditConductorPasswordResponse changePassword(EditConductorPasswordRequest request) {
        validateUpdatePassword(request);
        Conductor conductor = conductorRepository.findByPhone(request.getConductorPhoneNumber()).orElseThrow(() -> new conductorInputValidationException("Conductor not found with phone number"));
        mapToUpdateConductorPassword(conductor, request);

        Conductor savedEdit = conductorRepository.save(conductor);

        return mapToEditConductorPasswordResponse(savedEdit);
    }


    @Override
    public EditConductorAgeResponse changeAge(EditConductorAgeRequest request) {
        validateUpdateAge(request);
        Conductor conductor = conductorRepository.findByPhone(request.getConductorPhoneNumber()).orElseThrow(() -> new conductorInputValidationException("Conductor not found with phone number"));
        mapToUpdateConductorAge(conductor, request);

        Conductor savedEdit = conductorRepository.save(conductor);

        return mapToEditConductorAgeResponse(savedEdit);
    }


    @Override
    public EditConductorPhoneNumberResponse changePhoneNumber(EditConductorPhoneNumberRequest request) {
        validateUpdatePhoneNumber(request);
        Conductor conductor = conductorRepository.findByPhone(request.getConductorPhoneNumber()).orElseThrow(() -> new conductorInputValidationException("Conductor not found with phone number"));
        mapToUpdateConductorPhoneNumber(conductor, request);

        Conductor savedEdit = conductorRepository.save(conductor);

        return mapToEditConductorPhoneNumberResponse(savedEdit);
    }

    @Override
    public DeleteConductorResponse deleteConductor(DeleteConductorRequest request) {
        validateDeleteConductor(request);

        Conductor conductor = conductorRepository.findByPhone(request.getConductorPhoneNumber()).orElseThrow(() -> new conductorInputValidationException("Conductor not found with phone number"));
        conductorRepository.deleteByPhone(request.getConductorPhoneNumber());

        return mapToDeleteConductorResponse(conductor);
    }


    public ViewConductorProfileResponse viewProfile(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.trim().isEmpty())throw new conductorInputValidationException("Phone number cannot be empty");
        if(phoneNumber.length() < 11)throw new conductorInputValidationException("Phone number cannot be less than 11");
        if(phoneNumber.length() > 11)throw new conductorInputValidationException("Phone number cannot be more than 11");
        Conductor conductor = conductorRepository.findByPhone(phoneNumber).orElseThrow(() -> new conductorInputValidationException("Conductor not found"));
        return mapToViewConductorResponse(conductor);
    }




    private static void validateConductorInput(RegisterConductorRequest request) {
        if(request.getName() == null || request.getName().trim().isEmpty())throw new conductorInputValidationException("Name cannot be empty");
        if(request.getAge() == 0)throw new conductorInputValidationException("Age cannot be 0");
        if(request.getAge() < 18)throw new conductorInputValidationException("You are too young to be a conductor here");
        if(request.getAge() > 45)throw new conductorInputValidationException("You are too old to be a conductor here Sir/Ma");
        if(request.getPhone() == null || request.getPhone().trim().isEmpty())throw new  conductorInputValidationException("Phone cannot be empty");
        if(request.getPhone().length() < 11)throw new  conductorInputValidationException("Phone number cannot be less than 11");
        if(request.getPhone().length() > 11)throw new  conductorInputValidationException("Phone number cannot be more than 11");
        if(request.getGender() == null || request.getGender().trim().isEmpty())throw new  conductorInputValidationException("Gender cannot be empty");
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[^\\s]{6,15}$";
        if(!request.getPassword().matches(passwordPattern))throw new conductorInputValidationException("Passwords do not match");
    }


    private static void validateUpdateFullName(EditConductorFullNameRequest request) {
        if(request.getConductorPhoneNumber() == null || request.getConductorPhoneNumber().trim().isEmpty())throw new conductorInputValidationException("Phone number cannot be empty");
        if(request.getConductorPhoneNumber().length() < 11)throw new conductorInputValidationException("Phone number cannot be less than 11");
        if(request.getConductorPhoneNumber().length() > 11)throw new conductorInputValidationException("Phone number cannot be more than 11");
        if(request.getConductorNewFullName() == null || request.getConductorNewFullName().trim().isEmpty())throw new conductorInputValidationException("Name cannot be empty");
    }

    private static void validateUpdatePassword(EditConductorPasswordRequest request) {
        if(request.getConductorPhoneNumber() == null || request.getConductorPhoneNumber().trim().isEmpty())throw new conductorInputValidationException("Phone number cannot be empty");
        if(request.getConductorPhoneNumber().length() < 11)throw new conductorInputValidationException("Phone number cannot be less than 11");
        if(request.getConductorPhoneNumber().length() > 11)throw new conductorInputValidationException("Phone number cannot be more than 11");
        if(request.getConductorPassword() == null || request.getConductorPassword().trim().isEmpty())throw new conductorInputValidationException("Password cannot be empty");
    }

    private static void validateUpdateAge(EditConductorAgeRequest request) {
        if(request.getConductorPhoneNumber() == null || request.getConductorPhoneNumber().trim().isEmpty())throw new conductorInputValidationException("Phone number cannot be empty");
        if(request.getConductorPhoneNumber().length() < 11)throw new conductorInputValidationException("Phone number cannot be less than 11");
        if(request.getConductorPhoneNumber().length() > 11)throw new conductorInputValidationException("Phone number cannot be more than 11");
        if(request.getAge() == 0)throw new conductorInputValidationException("Age cannot be 0");
        if(request.getAge() < 18)throw new conductorInputValidationException("You are too young to be a conductor here");
        if(request.getAge() > 45)throw new conductorInputValidationException("You are too old to be a conductor here Sir/Ma");
    }

    private static void validateUpdatePhoneNumber(EditConductorPhoneNumberRequest request) {
        if(request.getConductorPhoneNumber() == null || request.getConductorPhoneNumber().trim().isEmpty())throw new conductorInputValidationException("Phone number cannot be empty");
        if(request.getConductorPhoneNumber().length() < 11)throw new conductorInputValidationException("Phone number cannot be less than 11");
        if(request.getConductorPhoneNumber().length() > 11)throw new conductorInputValidationException("Phone number cannot be more than 11");
        if(request.getConductorNewPhoneNumber().length() < 11)throw new  conductorInputValidationException("Phone number cannot be less than 11");
        if(request.getConductorNewPhoneNumber().length() > 11)throw new  conductorInputValidationException("Phone number cannot be more than 11");
        if(request.getConductorNewPhoneNumber() == null || request.getConductorNewPhoneNumber().trim().isEmpty())throw new conductorInputValidationException("phone number cannot be empty");
    }

    private void validateDeleteConductor(DeleteConductorRequest request) {
        if (request.getConductorPhoneNumber() == null || request.getConductorPhoneNumber().trim().isEmpty())throw new conductorInputValidationException("Phone number cannot be empty");
        if (request.getConductorPhoneNumber().length() != 11)throw new conductorInputValidationException("Phone number must be 11 digits");
        if (request.getConductorName() == null || request.getConductorName().trim().isEmpty())throw new conductorInputValidationException("Name cannot be empty");
    }


}
