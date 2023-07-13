package com.example.orderservice.client;

import com.example.orderservice.dto.ProductDTO;
import com.example.orderservice.dto.ProductServiceDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PutExchange;

@HttpExchange("/product")
public interface ProductClient {

    @GetExchange("/product-inventory-details/{productSerialNumber}")
    public ProductServiceDTO getProductInventoryDetails(@PathVariable("productSerialNumber") String productSerialNumber);

    @PutExchange("/update/{productSerialNumber}/{newQuantity}")
    public void updateProductInventory(@PathVariable String productSerialNumber,
                                       @PathVariable int newQuantity);
}
