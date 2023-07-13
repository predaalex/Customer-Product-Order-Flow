package com.example.productservice.entity;

import com.example.productservice.dto.ProductDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;

    @Column(name = "product_serial_number")
    private String productSerialNumber;

    @Column(name = "product_quantity")
    private int productQuantity;

    public Product() {
    }

    public Product(ProductDTO productDTO) {
        this.productName = productDTO.getProductName();
        this.productPrice = productDTO.getProductPrice();
        this.productSerialNumber = productDTO.getProductSerialNumber();
        this.productQuantity = productDTO.getProductQuantity();
    }

    public Product(Long productId, String productName, int productPrice, String productSerialNumber, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSerialNumber = productSerialNumber;
        this.productQuantity = productQuantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSerialNumber='" + productSerialNumber + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
