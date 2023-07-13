package com.example.orderservice.service;

import com.example.orderservice.client.CustomerClient;
import com.example.orderservice.dto.CustomerDTO;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.ProductServiceDTO;
import com.example.orderservice.dto.UpdateOrderDTO;
import com.example.orderservice.entity.Order;

public interface OrderService {
    boolean checkAccess(CustomerDTO customerDTO);

    boolean checkLimit(CustomerDTO customerDTO);

    void addOrder(OrderDTO orderDTO);

    boolean checkInventory(int productStock, int orderQuantity);

    void updateOrderQuantity(UpdateOrderDTO newOrderDTO);

    Order getOrderByOrderId(Long orderId);
}
