package com.example.orderservice.entity;

import com.example.orderservice.dto.ProductDTO;
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

    @Column(name = "price_currency")
    private String priceCurrency;

    @Column(name = "product_sku")
    private String productSku;

    @Column(name = "product_sn")
    private String productSerialNumber;

    @Column(name = "product_quantity")
    private int productQuantity;


    public Product(Long productId, String productName, int productPrice, String priceCurrency, String productSku, String productSerialNumber, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.priceCurrency = priceCurrency;
        this.productSku = productSku;
        this.productSerialNumber = productSerialNumber;
        this.productQuantity = productQuantity;
    }

    public Product(Product productDTO) {
        this.productName = productDTO.getProductName();
        this.productName = productDTO.getProductName();
        this.productPrice = productDTO.getProductPrice();
        this.priceCurrency = productDTO.getPriceCurrency();
        this.productSku = productDTO.getProductSku();
        this.productSerialNumber = productDTO.getProductSerialNumber();
        this.productQuantity = productDTO.getProductQuantity();
    }

    public Product() {

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

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
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
                ", priceCurrency='" + priceCurrency + '\'' +
                ", productSku='" + productSku + '\'' +
                ", productSerialNumber='" + productSerialNumber + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
