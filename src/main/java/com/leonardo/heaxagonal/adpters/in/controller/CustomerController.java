package com.leonardo.heaxagonal.adpters.in.controller;

import com.leonardo.heaxagonal.adpters.in.controller.mapper.CustomerMapper;
import com.leonardo.heaxagonal.adpters.in.controller.request.CustomerRequest;
import com.leonardo.heaxagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.execute(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }
}
