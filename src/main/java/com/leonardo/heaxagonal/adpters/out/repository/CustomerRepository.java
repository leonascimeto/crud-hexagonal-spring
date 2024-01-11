package com.leonardo.heaxagonal.adpters.out.repository;

import com.leonardo.heaxagonal.adpters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
