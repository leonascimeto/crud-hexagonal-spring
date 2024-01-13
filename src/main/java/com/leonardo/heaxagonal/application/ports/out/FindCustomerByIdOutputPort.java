package com.leonardo.heaxagonal.application.ports.out;

import com.leonardo.heaxagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String id);
}
