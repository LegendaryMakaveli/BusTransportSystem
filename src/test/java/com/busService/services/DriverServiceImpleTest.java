package com.busService.services;

import com.busService.Main;
import com.busService.datas.repositories.DriverRepository;
import com.busService.dtos.requests.DriverRequests.RegisterDriverRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
public class DriverServiceImpleTest {
    @Autowired
    private DriverService driverService;
    @Autowired
    private DriverRepository driverRepository;

    @AfterEach
    public void tearDown() {driverRepository.deleteAll();}

    @Test
    public void registerOneDriverAndCountIsOne() {
       RegisterDriverRequest registerDriver = getRegisterDriverRequest();
       driverService.registerDriver(registerDriver);

       assertEquals(1, driverRepository.count());

    }

    private static RegisterDriverRequest getRegisterDriverRequest() {
        RegisterDriverRequest driverRequest = new  RegisterDriverRequest();
        driverRequest.setRoles("Driver");
        driverRequest.setName("Alabi yello");
        driverRequest.setAge(30);
        driverRequest.setPhone("09077886655");
        driverRequest.setHeight(5.6);
        driverRequest.setLicenseNumber("JLK66998BH11");
        driverRequest.setPassword("AlabiOmoOro@2");
        driverRequest.setEmail("alabiyellow@gmail.com");
        driverRequest.setGender("Male");

        return driverRequest;
    }
}