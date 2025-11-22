package com.busService.datas.repositories;

import com.busService.datas.models.Conductor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConductorRepository extends MongoRepository<Conductor,String> {
    Optional<Conductor> findByPhone(String phoneNumber);
    void deleteByPhone(String phoneNumber);
}
