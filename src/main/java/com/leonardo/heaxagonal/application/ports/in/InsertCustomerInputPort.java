package com.leonardo.heaxagonal.application.ports.in;

import com.leonardo.heaxagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void execute(Customer customer, String zipCode);
}
