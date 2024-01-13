package com.leonardo.heaxagonal.adpters.in.consumer;

import com.leonardo.heaxagonal.adpters.in.consumer.mapper.CustomerMessageMapper;
import com.leonardo.heaxagonal.adpters.in.consumer.message.CustomerMessage;
import com.leonardo.heaxagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidateCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "leonardo")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.execute(customer, customerMessage.getZipCode());
    }
}
