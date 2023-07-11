package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerDTO;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        customerRepository.save(customer);
    }

    @Override
    public boolean checkIfSecretExists(String customerSecret) {
        return customerRepository.findAll().stream()
                .anyMatch(customer -> customer.getCustomerSecret().equals(customerSecret));
    }

    @Override
    public boolean checkCustomerContact(String customerContact) {
        if (customerContact.length() == 10){
            for(int i = 0; i<10; i++) {
                if (!Character.isDigit(customerContact.charAt(i)))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkEmail(String customerEmail) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(customerEmail);

        return matcher.matches();
    }

    @Override
    public CustomerDTO findCustomerByCustomerSecret(String customerSecret) {
        CustomerDTO customerDTO;
        Optional<Customer> customer = customerRepository.findByCustomerSecret(customerSecret);

        if (customer.isEmpty()) {
            return null;
        } else {
            customerDTO = new CustomerDTO(
                    customer.get().getCustomerName(),
                    customer.get().getCustomerEmail(),
                    customer.get().getCustomerContact(),
                    customer.get().getCustomerAddress(),
                    customer.get().isWriteAccess(),
                    customer.get().getCustomerSecret(),
                    customer.get().getOrderCreationLimit()
            );
            return customerDTO;
        }

    }
}
