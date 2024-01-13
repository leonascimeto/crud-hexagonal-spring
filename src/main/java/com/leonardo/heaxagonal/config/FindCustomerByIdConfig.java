package com.leonardo.heaxagonal.config;

import com.leonardo.heaxagonal.adpters.out.FindAddresByZipCodeAdpter;
import com.leonardo.heaxagonal.adpters.out.FindCustomerByIdAdapter;
import com.leonardo.heaxagonal.adpters.out.InsertCustomerAdapter;
import com.leonardo.heaxagonal.application.core.usecase.FindCustomerByUserIdUseCase;
import com.leonardo.heaxagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByUserIdUseCase findCustomerByUserIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByUserIdUseCase(findCustomerByIdAdapter);
    }
}
