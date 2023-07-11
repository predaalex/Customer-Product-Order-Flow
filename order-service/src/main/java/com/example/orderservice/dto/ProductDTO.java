package com.example.orderservice.dto;


import com.example.orderservice.entity.Product;

public class ProductDTO {

    private String productName;

    private int productPrice;

    private String priceCurrency;

    private String productSku;

    private String productSerialNumber;

    private int productQuantity;

    public ProductDTO() {
    }

    public ProductDTO(String productName, int productPrice, String priceCurrency, String productSku, String productSerialNumber, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.priceCurrency = priceCurrency;
        this.productSku = productSku;
        this.productSerialNumber = productSerialNumber;
        this.productQuantity = productQuantity;
    }

    public ProductDTO(Product product) {
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.priceCurrency = product.getPriceCurrency();
        this.productSku = product.getProductSku();
        this.productSerialNumber = product.getProductSerialNumber();
        this.productQuantity = product.getProductQuantity();
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
        return "ProductDTO{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", priceCurrency='" + priceCurrency + '\'' +
                ", productSku='" + productSku + '\'' +
                ", productSerialNumber='" + productSerialNumber + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
