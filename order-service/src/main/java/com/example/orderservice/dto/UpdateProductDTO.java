package com.example.orderservice.dto;

public class UpdateProductDTO {
    private String productSN;

    private int productQuantity;

    public UpdateProductDTO() {
    }

    public UpdateProductDTO(String productSN, int productQuantity) {
        this.productSN = productSN;
        this.productQuantity = productQuantity;
    }


    public String getProductSN() {
        return productSN;
    }

    public void setProductSN(String productSN) {
        this.productSN = productSN;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "UpdateProductDTO{" +
                "productSN='" + productSN + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
