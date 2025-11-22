package com.busService.services;

import com.busService.Main;
import com.busService.datas.repositories.BusRepositories;
import com.busService.dtos.requests.RegisterBusRequest;
import com.busService.exceptions.BusAlreadyExist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
class BusServicesImpleTest {
    @Autowired
    private BusServices busService;
    @Autowired
    private BusRepositories busRepositories;


    @AfterEach
    void tearDown() {
        busRepositories.deleteAll();
    }



    @Test
    public void registerABusAndCountIsOne() {
        RegisterBusRequest registerBusRequest = getRegisterBusRequest();

        busService.registerBus(registerBusRequest);
        assertEquals(1, busRepositories.count());
    }

    @Test
    public void registerTwoBusAndCountIsTwo(){
        RegisterBusRequest registerBusRequest = getRegisterBusRequest();
        RegisterBusRequest registerTwoBusRequest = getRegisterBusRequest();
        registerTwoBusRequest.setChasisNumber("yuwd67876dhyyq99");

        busService.registerBus(registerBusRequest);
        busService.registerBus(registerTwoBusRequest);
        assertEquals(2, busRepositories.count());

    }

    @Test
    public void RegisterTheSameBusTwiceShouldThrowException() {
        RegisterBusRequest first = getRegisterBusRequest();
        RegisterBusRequest second = getRegisterBusRequest();
        busService.registerBus(first);

        assertThrows(BusAlreadyExist.class, () -> busService.registerBus(second));
        assertEquals(1, busRepositories.count());
    }



    private static RegisterBusRequest getRegisterBusRequest() {
        RegisterBusRequest registerBusRequest = new RegisterBusRequest();
        registerBusRequest.setName("Volkswagen");
        registerBusRequest.setModel("Classic");
        registerBusRequest.setPlateNumber("KRD 234 XB");
        registerBusRequest.setColor("Yello");
        registerBusRequest.setYear(2001);
        registerBusRequest.setCapacity(45);
        registerBusRequest.setChasisNumber("kkk389hu2944ddu");
        return registerBusRequest;
    }


}