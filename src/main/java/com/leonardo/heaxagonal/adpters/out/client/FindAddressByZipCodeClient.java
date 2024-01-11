package com.leonardo.heaxagonal.adpters.out.client;

import com.leonardo.heaxagonal.adpters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "findAddressByZipCodeClient",
        url = "${hexagonal.client.address.url}"
)
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode")
    AddressResponse find(@PathVariable String zipCode);
}
