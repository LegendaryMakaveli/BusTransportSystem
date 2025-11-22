package com.busService.datas.repositories;

import com.busService.datas.models.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<Driver,String> {
    Optional<Driver> findByEmail(String driverEmail);
    void deleteByEmail(String driverEmail);
}
