package com.busService.datas.repositories;

import com.busService.datas.models.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BusRepositories extends MongoRepository<Bus,String> {
    Optional<Bus> findByChasisNumber(String chasisNumber);
}
