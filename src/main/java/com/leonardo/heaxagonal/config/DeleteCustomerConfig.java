package com.leonardo.heaxagonal.config;

import com.leonardo.heaxagonal.adpters.out.DeleteCustomerAdapter;
import com.leonardo.heaxagonal.application.core.usecase.DeleteCustomerUseCase;
import com.leonardo.heaxagonal.application.core.usecase.FindCustomerByUserIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {
    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(
            FindCustomerByUserIdUseCase findCustomerByUserIdUseCase,
            DeleteCustomerAdapter deleteCustomerAdapter
    ) {
        return new DeleteCustomerUseCase(findCustomerByUserIdUseCase, deleteCustomerAdapter);
    }
}
