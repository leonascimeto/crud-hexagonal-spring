package com.leonardo.heaxagonal.adpters.in.controller;

import com.leonardo.heaxagonal.adpters.in.controller.mapper.CustomerMapper;
import com.leonardo.heaxagonal.adpters.in.controller.request.CustomerRequest;
import com.leonardo.heaxagonal.adpters.in.controller.response.CustomerResponse;
import com.leonardo.heaxagonal.application.ports.in.DeleteCustomerInputPort;
import com.leonardo.heaxagonal.application.ports.in.FindCustomerByIdInputPort;
import com.leonardo.heaxagonal.application.ports.in.InsertCustomerInputPort;
import com.leonardo.heaxagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerInputPort deleteCustomerInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.execute(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id){
        var customer = findCustomerByIdInputPort.execute(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody @Valid CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.execute(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerInputPort.execute(id);
        return ResponseEntity.noContent().build();
    }

}
