package com.leonardo.heaxagonal.config;

import com.leonardo.heaxagonal.adpters.out.FindAddresByZipCodeAdpter;
import com.leonardo.heaxagonal.adpters.out.UpdateCustomerAdapter;
import com.leonardo.heaxagonal.application.core.usecase.FindCustomerByUserIdUseCase;
import com.leonardo.heaxagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByUserIdUseCase findCustomerByUserIdUseCase,
            FindAddresByZipCodeAdpter findAddresByZipCodeAdpter,
            UpdateCustomerAdapter updateCustomerAdapter

    ) {
        return new UpdateCustomerUseCase(findCustomerByUserIdUseCase, findAddresByZipCodeAdpter, updateCustomerAdapter);
    }
}
