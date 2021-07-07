package com.egen.texashamburger.repository;

import com.egen.texashamburger.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location,String> {

}
