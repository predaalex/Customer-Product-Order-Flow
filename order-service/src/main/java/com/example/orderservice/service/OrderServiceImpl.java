package com.example.orderservice.service;

import com.example.orderservice.dto.CustomerDTO;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.ProductDTO;
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
            Optional<Product> existingProduct = productRepository.findByProductSerialNumber(product.getProductSerialNumber());
            if (existingProduct.isPresent()) {
                order.setProduct(existingProduct.get());
            } else {
                product = productRepository.save(product);
                order.setProduct(product);
            }
        }
        orderRepository.save(order);
    }
}
