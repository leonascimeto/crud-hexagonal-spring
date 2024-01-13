package com.leonardo.heaxagonal.adpters.out;

import com.leonardo.heaxagonal.adpters.out.repository.CustomerRepository;
import com.leonardo.heaxagonal.adpters.out.repository.mapper.CustomerEntityMapper;
import com.leonardo.heaxagonal.application.core.domain.Customer;
import com.leonardo.heaxagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
