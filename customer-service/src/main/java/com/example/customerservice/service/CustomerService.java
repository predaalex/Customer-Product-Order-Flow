package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerDTO;
import com.example.customerservice.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();

    void addCustomer(CustomerDTO customerDTO);

    boolean checkIfSecretExists(String customerSecret);

    boolean checkCustomerContact(String customerContact);

    boolean checkEmail(String customerEmail);

    CustomerDTO findCustomerByCustomerSecret(String customerSecret);

    void updateWriteAccess(String customerSecret, boolean writeAccess);
}
