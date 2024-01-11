package com.leonardo.heaxagonal.application.ports.out;

import com.leonardo.heaxagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
