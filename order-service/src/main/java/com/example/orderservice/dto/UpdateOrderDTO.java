package com.example.orderservice.dto;

public class UpdateOrderDTO {
    private Long orderNumber;

    private UpdateProductDTO updateProductDTO;

    public UpdateOrderDTO(Long orderNumber, UpdateProductDTO updateProductDTO) {
        this.orderNumber = orderNumber;
        this.updateProductDTO = updateProductDTO;
    }

    public UpdateOrderDTO() {
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public UpdateProductDTO getUpdateProductDTO() {
        return updateProductDTO;
    }

    public void setUpdateProductDTO(UpdateProductDTO updateProductDTO) {
        this.updateProductDTO = updateProductDTO;
    }

    @Override
    public String toString() {
        return "UpdateOrderDTO{" +
                "orderNumber=" + orderNumber +
                ", updateProductDTO=" + updateProductDTO +
                '}';
    }
}
