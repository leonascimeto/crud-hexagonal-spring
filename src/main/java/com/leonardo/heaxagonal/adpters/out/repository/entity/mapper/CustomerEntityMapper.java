package com.leonardo.heaxagonal.adpters.out.repository.entity.mapper;

import com.leonardo.heaxagonal.adpters.out.repository.entity.CustomerEntity;
import com.leonardo.heaxagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
