package com.leonardo.heaxagonal.config;

import com.leonardo.heaxagonal.adpters.out.FindAddresByZipCodeAdpter;
import com.leonardo.heaxagonal.adpters.out.InsertCustomerAdapter;
import com.leonardo.heaxagonal.adpters.out.SendCpfValidationAdapter;
import com.leonardo.heaxagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddresByZipCodeAdpter findAddresByZipCodeAdpter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddresByZipCodeAdpter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
