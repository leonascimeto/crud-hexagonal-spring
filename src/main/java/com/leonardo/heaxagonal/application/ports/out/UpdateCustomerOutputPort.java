package com.leonardo.heaxagonal.application.ports.out;

import com.leonardo.heaxagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
