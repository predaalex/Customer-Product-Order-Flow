package com.example.customerservice.controller;

import com.example.customerservice.dto.CustomerDTO;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customerDetails")
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> getAll() {
        LOGGER.info("CustomerDetails getAll()");
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerSecret}")
    public CustomerDTO findCustomerByCustomerSecret(@PathVariable("customerSecret") String customerSecret) {
        CustomerDTO customerDTO = customerService.findCustomerByCustomerSecret(customerSecret);

        if (customerDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with secret " + customerSecret +
                    " NOT found!");
        } else {
            return customerDTO;
        }
    }


    @PostMapping()
    public ResponseEntity<Object> addCustomer(@RequestBody CustomerDTO customerDTO) {

        boolean secretExists = customerService.checkIfSecretExists(customerDTO.getCustomerSecret());
        boolean checkCustomerContact = customerService.checkCustomerContact(customerDTO.getCustomerContact());
        boolean checkEmail = customerService.checkEmail(customerDTO.getCustomerEmail());

        if (secretExists) {
            String errorMessage = "Duplicate Record Not Allowed";
            String errorDetails = "Customer Secret Already Exists";
            Map<String, String> map = new HashMap<>();

            map.put("message", errorMessage);
            map.put("details", errorDetails);

            LOGGER.info("CustomerDetails add {} ERROR: secretExists", customerDTO.getCustomerName());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        } else if (!checkCustomerContact) {
            LOGGER.info("CustomerDetails add {} ERROR: Invalid Contact", customerDTO.getCustomerName());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Contact is invalid");
        } else if (!checkEmail) {
            LOGGER.info("CustomerDetails add {} ERROR: Invalid Email", customerDTO.getCustomerName());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Email is invalid");
        } else {
            customerService.addCustomer(customerDTO);
            Map<String, String> response = new HashMap<>();

            response.put("Message", "Customer Record successfully created");

            LOGGER.info("CustomerDetails add SUCCESSFULL: {}", customerDTO.getCustomerName());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

    @PutMapping("/update-write-access/{customerSecret}/{writeAccess}")
    public void updateWriteAccess(@PathVariable String customerSecret,
                                  @PathVariable boolean writeAccess) {
        customerService.updateWriteAccess(customerSecret, writeAccess);
    }
}
