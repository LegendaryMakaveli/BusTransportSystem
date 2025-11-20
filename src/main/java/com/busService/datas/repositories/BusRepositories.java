package com.busService.datas.repositories;

import com.busService.datas.models.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepositories extends MongoRepository<Bus,String> {
}
