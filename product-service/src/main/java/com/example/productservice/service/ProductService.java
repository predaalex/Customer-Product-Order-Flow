package com.example.productservice.service;

import com.example.productservice.dto.ProductDTO;

public interface ProductService {
    ProductDTO getProductInventoryDetails(String productSerialNumber);

    void updateProductInventory(String productSerialNumber, int newQuantity);
}
