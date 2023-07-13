package com.example.orderservice.controller;

import com.example.orderservice.client.CurrencyClient;
import com.example.orderservice.client.CustomerClient;
import com.example.orderservice.client.ProductClient;
import com.example.orderservice.dto.CustomerDTO;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.ProductServiceDTO;
import com.example.orderservice.dto.UpdateOrderDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    private final CustomerClient customerClient;

    private final CurrencyClient currencyClient;

    private final ProductClient productClient;

    @Autowired
    public OrderController(OrderService orderService, CustomerClient customerClient,
                           CurrencyClient currencyClient, ProductClient productClient) {
        this.orderService = orderService;
        this.customerClient = customerClient;
        this.currencyClient = currencyClient;
        this.productClient = productClient;
    }

    @PostMapping()
    public ResponseEntity<Object> addOrder(@RequestBody OrderDTO orderDTO) {
        CustomerDTO customerDTO = customerClient.findCustomerByCustomerSecret(orderDTO.getCustomerSecret());
        boolean checkAccess = orderService.checkAccess(customerDTO);
        boolean checkLimit = orderService.checkLimit(customerDTO);
        ProductServiceDTO productServiceDTO = productClient.getProductInventoryDetails(orderDTO.getProduct().getProductSerialNumber());
        boolean checkInventory = orderService.checkInventory(
                productServiceDTO.getProductQuantity(),
                orderDTO.getProduct().getProductQuantity());

        if (!checkInventory) {
            String message = "You are unable to place an order because the quantity is insufficient.";
            String error = "Insufficient Quantity";
            String orderQuantity = String.valueOf(orderDTO.getProduct().getProductQuantity());
            String quantityAvailable = String.valueOf(productServiceDTO.getProductQuantity());

            Map<String, String> map = new HashMap<>();

            map.put("message", message);
            map.put("error", error);
            map.put("orderQuantity", orderQuantity);
            map.put("quantityAvailable", quantityAvailable);
            LOGGER.info("ERROR: Insufficient Quantity");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }

        int convertedCurrency = currencyClient.convert(orderDTO.getProduct().getPriceCurrency(),
                orderDTO.getProduct().getProductPrice());

        if (convertedCurrency == -1) {
            String message = "Only RS accepatable as a Currency to place an Order";
            String error = "Invalid Currency";

            Map<String, String> map = new HashMap<>();

            map.put("message", message);
            map.put("error", error);
            LOGGER.info("GET /convert/{fromCurrency}/{value} ERROR: Invalid Currency");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }

        orderDTO.getProduct().setPriceCurrency("RS");
        orderDTO.getProduct().setProductPrice(convertedCurrency);


        if (!checkAccess) {
            String message = "You Do Not Have Access to Perform This Operation.";
            String error = "Invalid Access";

            Map<String, String> map = new HashMap<>();

            map.put(message, error);
            LOGGER.info("POST /order ERROR: Invalid Access");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);

        } else if (!checkLimit) {
            String message = "You do not have a sufficient limit to create a new order,so please contact " +
                    "the support team for additional limit subscription.";
            String error = "Invalid Order Creation Limit";

            Map<String, String> map = new HashMap<>();

            map.put(message, error);

            LOGGER.info("POST /order ERROR: Invalid Order Creation Limit");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);

        } else {
            orderService.addOrder(orderDTO);
            Map<String, String> response = new HashMap<>();

            response.put("Message", "Customer product order successfully created and " +
                    "you customer will receive order details on email Shortly");
            response.put("EmailTrigger", "Yes");
            response.put("CustomerSecret", orderDTO.getCustomerSecret());

            productClient.updateProductInventory(orderDTO.getProduct().getProductSerialNumber(),
                    productServiceDTO.getProductQuantity() - orderDTO.getProduct().getProductQuantity());

            LOGGER.info("Order add SUCCESSFULL: {}", orderDTO.getCustomerSecret());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        }
    }

    @PutMapping("/updateProductQuantity")
    public ResponseEntity<Object> updateProductQuantity(@RequestBody UpdateOrderDTO newOrderDTO) {

        System.out.println(newOrderDTO);

        ProductServiceDTO productServiceDTO = productClient.getProductInventoryDetails(newOrderDTO.getUpdateProductDTO().getProductSN());
        Order oldOrderDTO = orderService.getOrderByOrderId(newOrderDTO.getOrderNumber());

        int deltaQuantity = newOrderDTO.getUpdateProductDTO().getProductQuantity() - oldOrderDTO.getProduct().getProductQuantity();

        boolean checkInventory;

        if( deltaQuantity < 0) {
            checkInventory = true;
        } else {
            checkInventory = orderService.checkInventory(
                    productServiceDTO.getProductQuantity(),
                    newOrderDTO.getUpdateProductDTO().getProductQuantity());
        }

        if (!checkInventory) {
            String message = "You are unable to place an order because the quantity is insufficient.";
            String error = "Insufficient Quantity";
            String orderQuantity = String.valueOf(deltaQuantity);
            String quantityAvailable = String.valueOf(productServiceDTO.getProductQuantity());

            Map<String, String> map = new HashMap<>();

            map.put("message", message);
            map.put("error", error);
            map.put("orderQuantity", orderQuantity);
            map.put("quantityAvailable", quantityAvailable);
            LOGGER.info("ERROR: Insufficient Quantity");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }

        orderService.updateOrderQuantity(newOrderDTO);

        Order order = orderService.getOrderByOrderId(newOrderDTO.getOrderNumber());

        customerClient.updateWriteAccess(order.getCustomerSecret(), false);

        productClient.updateProductInventory(newOrderDTO.getUpdateProductDTO().getProductSN(),
                productServiceDTO.getProductQuantity() - deltaQuantity);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Update Request has been Accepted");
    }
}
