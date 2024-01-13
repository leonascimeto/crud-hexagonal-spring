package com.leonardo.heaxagonal.application.core.usecase;

import com.leonardo.heaxagonal.application.core.domain.Customer;
import com.leonardo.heaxagonal.application.ports.in.InsertCustomerInputPort;
import com.leonardo.heaxagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.leonardo.heaxagonal.application.ports.out.InsertCustomerOutputPort;
import com.leonardo.heaxagonal.application.ports.out.SendCpfForValidationOutportPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutportPort sendCpfForValidationOutportPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutportPort sendCpfForValidationOutportPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutportPort = sendCpfForValidationOutportPort;
    }

    @Override
    public void execute(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutportPort.send(customer.getCpf());
    }
}
