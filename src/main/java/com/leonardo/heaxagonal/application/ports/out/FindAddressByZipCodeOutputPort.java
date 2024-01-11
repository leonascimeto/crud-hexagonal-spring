package com.leonardo.heaxagonal.application.ports.out;

import com.leonardo.heaxagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
