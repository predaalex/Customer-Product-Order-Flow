package com.example.orderservice.client;

import com.example.orderservice.dto.CustomerDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@HttpExchange("/customerDetails")
public interface CustomerClient {

    @GetExchange("/{customerSecret}")
    public CustomerDTO findCustomerByCustomerSecret(@PathVariable("customerSecret") String customerSecret);

    @PutExchange("/update-write-access/{customerSecret}/{writeAccess}")
    public void updateWriteAccess(@PathVariable String customerSecret,
                                  @PathVariable boolean writeAccess);

}
