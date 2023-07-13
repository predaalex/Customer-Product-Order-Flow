package com.example.orderservice.service;

import com.example.orderservice.dto.*;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.Product;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public boolean checkAccess(CustomerDTO customerDTO) {
        return customerDTO.getWriteAccess();
    }

    @Override
    public boolean checkLimit(CustomerDTO customerDTO) {
        return customerDTO.getOrderCreationLimit() > 0;
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO);
        Product product = order.getProduct();
        if (product != null && product.getProductSerialNumber() != null) {
            product = productRepository.save(product);
            order.setProduct(product);
        }
        orderRepository.save(order);
    }

    @Override
    public boolean checkInventory(int productStock, int orderQuantity) {
        return productStock >= orderQuantity;
    }

    @Override
    public void updateOrderQuantity(UpdateOrderDTO newOrderDTO) {
        Order order = orderRepository.findById(newOrderDTO.getOrderNumber()).get();
        Product product = order.getProduct();

        product.setProductQuantity(newOrderDTO.getUpdateProductDTO().getProductQuantity());
        order.setProduct(product);
        order.setOrderStatus("Updated");

        orderRepository.save(order);
    }

    @Override
    public Order getOrderByOrderId(Long orderId) {
        return orderRepository.findById(orderId).get();
    }


}
