package com.leonardo.heaxagonal.application.core.usecase;

import com.leonardo.heaxagonal.application.core.domain.Customer;
import com.leonardo.heaxagonal.application.ports.in.FindCustomerByIdInputPort;
import com.leonardo.heaxagonal.application.ports.in.UpdateCustomerInputPort;
import com.leonardo.heaxagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.leonardo.heaxagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void execute(Customer customer, String zipCode) {
        findCustomerByIdInputPort.execute(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
