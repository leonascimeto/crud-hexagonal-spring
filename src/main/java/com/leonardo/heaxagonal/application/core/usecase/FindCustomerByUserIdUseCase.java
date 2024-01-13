package com.leonardo.heaxagonal.application.core.usecase;

import com.leonardo.heaxagonal.application.core.domain.Customer;
import com.leonardo.heaxagonal.application.ports.in.FindCustomerByIdInputPort;
import com.leonardo.heaxagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByUserIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByUserIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer execute(String userId) {
        return findCustomerByIdOutputPort.find(userId).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
