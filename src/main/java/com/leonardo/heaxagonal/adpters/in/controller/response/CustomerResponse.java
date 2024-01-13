package com.leonardo.heaxagonal.adpters.in.controller.response;

import com.leonardo.heaxagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;
}
