package com.leonardo.heaxagonal.adpters.in.consumer.mapper;

import com.leonardo.heaxagonal.adpters.in.consumer.message.CustomerMessage;
import com.leonardo.heaxagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
