package com.example.customerservice.entity;

import com.example.customerservice.dto.CustomerDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_customer_id")
    private Long uniqueCustomerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_contact")
    private String customerContact;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "write_access")
    private boolean writeAccess;

    @Column(name = "customer_secret")
    private String customerSecret;

    @Column(name = "order_creation_limit")
    private Integer orderCreationLimit;

    public Customer() {
    }

    public Customer(CustomerDTO customerDTO) {
        this.customerName = customerDTO.getCustomerName();
        this.customerEmail = customerDTO.getCustomerEmail();
        this.customerContact = customerDTO.getCustomerContact();
        this.customerAddress = customerDTO.getCustomerAddress();
        this.writeAccess = customerDTO.isWriteAccess();
        this.customerSecret = customerDTO.getCustomerSecret();
        this.orderCreationLimit = customerDTO.getOrderCreationLimit();
    }

    public Long getUniqueCustomerId() {
        return uniqueCustomerId;
    }

    public void setUniqueCustomerId(Long uniqueCustomerId) {
        this.uniqueCustomerId = uniqueCustomerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public boolean isWriteAccess() {
        return writeAccess;
    }

    public void setWriteAccess(boolean writeAccess) {
        this.writeAccess = writeAccess;
    }

    public String getCustomerSecret() {
        return customerSecret;
    }

    public void setCustomerSecret(String customerSecret) {
        this.customerSecret = customerSecret;
    }

    public Integer getOrderCreationLimit() {
        return orderCreationLimit;
    }

    public void setOrderCreationLimit(Integer orderCreationLimit) {
        this.orderCreationLimit = orderCreationLimit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "uniqueCustomerId=" + uniqueCustomerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerContact=" + customerContact +
                ", customerAddress='" + customerAddress + '\'' +
                ", writeAccess=" + writeAccess +
                ", customerSecret='" + customerSecret + '\'' +
                ", orderCreationLimit=" + orderCreationLimit +
                '}';
    }
}
