package com.leonardo.heaxagonal.application.core.usecase;

import com.leonardo.heaxagonal.application.ports.in.DeleteCustomerInputPort;
import com.leonardo.heaxagonal.application.ports.in.FindCustomerByIdInputPort;
import com.leonardo.heaxagonal.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;

    public DeleteCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerOutputPort deleteCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
    }

    @Override
    public void execute(String id) {
        findCustomerByIdInputPort.execute(id);
        deleteCustomerOutputPort.delete(id);
    }
}
