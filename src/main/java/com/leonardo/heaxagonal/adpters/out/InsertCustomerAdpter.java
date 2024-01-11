package com.leonardo.heaxagonal.adpters.out;

import com.leonardo.heaxagonal.adpters.out.repository.CustomerRepository;
import com.leonardo.heaxagonal.adpters.out.repository.entity.mapper.CustomerEntityMapper;
import com.leonardo.heaxagonal.application.core.domain.Customer;
import com.leonardo.heaxagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdpter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
