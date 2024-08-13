package com.codegym.test_module4.dto;

public interface OrderProductDTO {
    Long getOrderId();       // Mã đơn hàng

    String getProductName();  // Tên sản phẩm

    Double getPrice();        // Giá sản phẩm

    String getCategory();     // Loại sản phẩm

    java.util.Date getOrderDate();  // Ngày mua

    Integer getQuantity();    // Số lượng

    Double getTotalAmount();  // Tổng tiền (giá * số lượng)
}

