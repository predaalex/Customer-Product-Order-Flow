package com.example.customerservice.dto;

import jakarta.persistence.Column;

public class CustomerDTO {

    private String customerName;

    private String customerEmail;

    private String customerContact;

    private String customerAddress;

    private boolean writeAccess;

    private String customerSecret;

    private Integer orderCreationLimit;

    public CustomerDTO(String customerName, String customerEmail, String customerContact, String customerAddress, boolean writeAccess, String customerSecret, Integer orderCreationLimit) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerContact = customerContact;
        this.customerAddress = customerAddress;
        this.writeAccess = writeAccess;
        this.customerSecret = customerSecret;
        this.orderCreationLimit = orderCreationLimit;
    }

    public CustomerDTO() {
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
        return "CustomerDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerContact=" + customerContact +
                ", customerAddress='" + customerAddress + '\'' +
                ", writeAccess=" + writeAccess +
                ", customerSecret='" + customerSecret + '\'' +
                ", orderCreationLimit=" + orderCreationLimit +
                '}';
    }
}
