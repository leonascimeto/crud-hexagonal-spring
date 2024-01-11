package com.leonardo.heaxagonal.adpters.out.client.mapper;

import com.leonardo.heaxagonal.adpters.out.client.response.AddressResponse;
import com.leonardo.heaxagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressReponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
