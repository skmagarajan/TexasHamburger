package com.egen.texashamburger.repository;

import com.egen.texashamburger.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

}
