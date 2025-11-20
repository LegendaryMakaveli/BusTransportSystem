package com.busService.datas.repositories;

import com.busService.datas.models.Maintance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaintanceRepository extends MongoRepository<Maintance,String> {
}
