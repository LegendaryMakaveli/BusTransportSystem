package com.busService.services;

import com.busService.Main;
import com.busService.datas.models.Conductor;
import com.busService.datas.repositories.ConductorRepository;
import com.busService.dtos.requests.conductorRequests.*;
import com.busService.dtos.responses.ConductorResponses.DeleteConductorResponse;
import com.busService.dtos.responses.ConductorResponses.ViewConductorProfileResponse;
import com.busService.exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.busService.datas.models.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
public class ConductorServiceImpleTest {
    @Autowired
    private ConductorService conductorService;

    @Autowired
    private ConductorRepository conductorRepository;

    @AfterEach
    public void tearDown() {conductorRepository.deleteAll();}

    @Test
    public void testThatRegisterOneConductorAndCountIsOne() {
       RegisterConductorRequest registerConductor = registerRequest();
       conductorService.registerConductor(registerConductor);

       assertEquals(1, conductorRepository.count());

    }

    @Test
    public void testThatRegisterTwoConductorAndCountIsTwo(){
        RegisterConductorRequest registerConductor = registerRequest();
        RegisterConductorRequest request = registerRequest();
        request.setPhone("09088776655");

        conductorService.registerConductor(registerConductor);
        conductorService.registerConductor(request);

        assertEquals(2, conductorRepository.count());
    }

    @Test
    public void testThatRegitserOneConductorTwiceButCountIsOne(){
        RegisterConductorRequest request = registerRequest();
        RegisterConductorRequest registerConductor = registerRequest();
        conductorService.registerConductor(request);

        assertThrows(UserAlreadyExistException.class, () -> conductorService.registerConductor(registerConductor));
    }

    @Test
    public void testThatEditTheFullNameOfAConductor(){
        RegisterConductorRequest request = registerRequest();
        conductorService.registerConductor(request);
        EditConductorFullNameRequest edit = new EditConductorFullNameRequest();
        edit.setConductorPhoneNumber("08123456789");
        edit.setConductorNewFullName("Irunmulowo Aina");

        conductorService.changeFullName(edit);
        Conductor updated = conductorRepository.findByPhone("08123456789").get();

        assertEquals("IRUNMULOWO AINA", updated.getName());
    }

    @Test
    public void testThatEditConductorPassword(){
        RegisterConductorRequest request = registerRequest();
        request.setPhone("09122338899");
        conductorService.registerConductor(request);
        EditConductorPasswordRequest edit = new EditConductorPasswordRequest();
        edit.setConductorPhoneNumber("09122338899");
        edit.setConductorPassword("AlabiOdaran@9");

        conductorService.changePassword(edit);
        Conductor updated = conductorRepository.findByPhone("09122338899").get();

        assertEquals("ALABIODARAN@9", updated.getPassword());
    }

    @Test
    public void testThatEditConductorAge(){
        RegisterConductorRequest request = registerRequest();
        conductorService.registerConductor(request);
        EditConductorAgeRequest edit = new EditConductorAgeRequest();
        edit.setConductorPhoneNumber("08123456789");
        edit.setAge(40);

        conductorService.changeAge(edit);
        Conductor updated = conductorRepository.findByPhone("08123456789").get();

        assertEquals(40, updated.getAge());
    }

    @Test
    public void testThatEditConductorPhone(){
        RegisterConductorRequest request = registerRequest();
        conductorService.registerConductor(request);
        EditConductorPhoneNumberRequest edit = new EditConductorPhoneNumberRequest();
        edit.setConductorPhoneNumber("08123456789");
        edit.setConductorNewPhoneNumber("09089987887");

        conductorService.changePhoneNumber(edit);
        Conductor updated = conductorRepository.findByPhone("09089987887").get();

        assertEquals("09089987887", updated.getPhone());
    }

    @Test
    public void testThatDeleteConductor(){
        RegisterConductorRequest registerConductor = registerRequest();
        conductorService.registerConductor(registerConductor);

        assertEquals(1, conductorRepository.count());
        DeleteConductorRequest deleteRequest = new DeleteConductorRequest();
        deleteRequest.setConductorName("Mudashiru Alabi");
        deleteRequest.setConductorPhoneNumber("08123456789");

        DeleteConductorResponse deleteResponse = conductorService.deleteConductor(deleteRequest);

        assertEquals(0, conductorRepository.count());
        assertEquals("Ehya!!! Goodbye ooo ", deleteResponse.getGoodByeMessage());
    }

    @Test
    public void testThatViewConductorProfile(){
        RegisterConductorRequest registerConductor = registerRequest();
        conductorService.registerConductor(registerConductor);

        ViewConductorProfileResponse response = conductorService.viewProfile("08123456789");
        assertEquals("MUDASHIRU ALABI", response.getName());
        assertEquals("08123456789", response.getPhone());
        assertEquals(25, response.getAge());
        assertEquals(MALE, response.getGender());

    }


    private static RegisterConductorRequest registerRequest() {
        RegisterConductorRequest request = new RegisterConductorRequest();
        request.setRole("Conductor");
        request.setName("Mudashiru Alabi");
        request.setAge(25);
        request.setGender("male");
        request.setPhone("08123456789");
        request.setPassword("AlabiMush@9");

        return request;
    }
}