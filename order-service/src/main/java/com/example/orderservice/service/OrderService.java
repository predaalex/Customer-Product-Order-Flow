package com.example.orderservice.service;

import com.example.orderservice.client.CustomerClient;
import com.example.orderservice.dto.CustomerDTO;
import com.example.orderservice.dto.OrderDTO;

public interface OrderService {
    boolean checkAccess(CustomerDTO customerDTO);

    boolean checkLimit(CustomerDTO customerDTO);

    void addOrder(OrderDTO orderDTO);
}
