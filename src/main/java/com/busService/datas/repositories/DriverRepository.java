package com.busService.datas.repositories;

import com.busService.datas.models.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver,String> {
}
