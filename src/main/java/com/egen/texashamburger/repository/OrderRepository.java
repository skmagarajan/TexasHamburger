package com.egen.texashamburger.repository;

import com.egen.texashamburger.entity.CustomerOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<CustomerOrder, String> {

}
