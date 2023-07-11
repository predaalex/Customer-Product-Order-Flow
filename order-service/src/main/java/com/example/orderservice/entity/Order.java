package com.example.orderservice.entity;

import com.example.orderservice.dto.OrderDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "customer_secret")
    private String customerSecret;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_status")
    private String orderStatus;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order(Long orderId, String customerSecret, Date orderDate, String orderStatus, Product productDTO) {
        this.orderId = orderId;
        this.customerSecret = customerSecret;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.product = productDTO;
    }

    public Order(OrderDTO orderDTO) {
        this.customerSecret = orderDTO.getCustomerSecret();
        this.orderDate = orderDTO.getOrderDate();
        this.orderStatus = orderDTO.getOrderStatus();
        this.product = orderDTO.getProduct();
    }

    public Order() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerSecret='" + customerSecret + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", productDTO=" + product +
                '}';
    }
}
