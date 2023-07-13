package com.example.productservice.controller;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.service.ProductService;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product-inventory-details/{productSerialNumber}")
    public ProductDTO getProductInventoryDetails(@PathVariable String productSerialNumber) {
        return productService.getProductInventoryDetails(productSerialNumber);
    }

    @PutMapping("/update/{productSerialNumber}/{newQuantity}")
    public void updateProductInventory(@PathVariable String productSerialNumber,
                                       @PathVariable int newQuantity) {
        productService.updateProductInventory(productSerialNumber, newQuantity);
    }
}
