package com.example.orderservice.client;

import com.example.orderservice.dto.CustomerDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface CustomerClient {

    @GetExchange("customerDetails/{customerSecret}")
    public CustomerDTO findCustomerByCustomerSecret(@PathVariable("customerSecret") String customerSecret);

}
