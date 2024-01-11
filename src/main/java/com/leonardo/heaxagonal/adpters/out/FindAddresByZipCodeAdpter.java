package com.leonardo.heaxagonal.adpters.out;

import com.leonardo.heaxagonal.adpters.out.client.FindAddressByZipCodeClient;
import com.leonardo.heaxagonal.adpters.out.client.mapper.AddressReponseMapper;
import com.leonardo.heaxagonal.application.core.domain.Address;
import com.leonardo.heaxagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddresByZipCodeAdpter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressReponseMapper addressReponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressReponseMapper.toAddress(addressResponse);
    }
}
