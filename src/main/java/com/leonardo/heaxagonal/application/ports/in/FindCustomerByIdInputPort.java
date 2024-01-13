package com.leonardo.heaxagonal.application.ports.in;

import com.leonardo.heaxagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer execute(String id);
}
