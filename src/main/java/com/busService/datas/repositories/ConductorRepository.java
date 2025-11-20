package com.busService.datas.repositories;

import com.busService.datas.models.Conductor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConductorRepository extends MongoRepository<Conductor,String> {
}
