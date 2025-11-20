package com.busService.datas.repositories;

import com.busService.datas.models.Routes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoutesRepository extends MongoRepository<Routes,String> {
}
