package com.leonardo.heaxagonal.adpters.out;

import com.leonardo.heaxagonal.adpters.out.repository.CustomerRepository;
import com.leonardo.heaxagonal.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
