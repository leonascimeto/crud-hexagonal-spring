package com.leonardo.heaxagonal.adpters.in.controller.mapper;

import com.leonardo.heaxagonal.adpters.in.controller.request.CustomerRequest;
import com.leonardo.heaxagonal.adpters.in.controller.response.CustomerResponse;
import com.leonardo.heaxagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
