package com.example.productservice.dto;

import com.example.productservice.entity.Product;

public class ProductDTO {

    private String productName;

    private int productPrice;

    private String productSerialNumber;
    
    private int productQuantity;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productSerialNumber = product.getProductSerialNumber();
        this.productQuantity = product.getProductQuantity();
    }

    public ProductDTO(String productName, int productPrice, String productSerialNumber, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSerialNumber = productSerialNumber;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public void setProductSerialNumber(String productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSerialNumber='" + productSerialNumber + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}