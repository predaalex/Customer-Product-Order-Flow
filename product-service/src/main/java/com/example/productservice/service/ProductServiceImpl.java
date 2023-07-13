package com.example.productservice.service;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductDTO getProductInventoryDetails(String productSerialNumber) {

        ProductDTO productDTO;

        Optional<Product> product = productRepository.findByProductSerialNumber(productSerialNumber);

        if (product.isPresent()) {
            productDTO = new ProductDTO(product.get());
            return productDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product S/N NOT FOUND!");
        }
    }

    @Override
    public void updateProductInventory(String productSerialNumber, int newQuantity) {

        Optional<Product> optionalProductDTO = productRepository.findByProductSerialNumber(productSerialNumber);

        if(optionalProductDTO.isPresent()) {
            Product product = optionalProductDTO.get();

            product.setProductQuantity(newQuantity);
            productRepository.save(product);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product S/N NOT FOUND!");
        }

    }
}
