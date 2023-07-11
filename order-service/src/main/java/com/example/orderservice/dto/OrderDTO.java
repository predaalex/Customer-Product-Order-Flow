package com.example.orderservice.dto;

import com.example.orderservice.entity.Product;

import java.util.Date;

public class OrderDTO {
    private String customerSecret;
    private Date orderDate;

    private String orderStatus;

    private Product product;

    public OrderDTO(String customerSecret, Date orderDate, String orderStatus, Product product) {
        this.customerSecret = customerSecret;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.product = product;
    }

    public String getCustomerSecret() {
        return customerSecret;
    }

    public void setCustomerSecret(String customerSecret) {
        this.customerSecret = customerSecret;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product1) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "customerSecret='" + customerSecret + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", product=" + product +
                '}';
    }
}
