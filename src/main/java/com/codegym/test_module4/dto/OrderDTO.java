package com.codegym.test_module4.dto;

    public class OrderDTO {
        private Long orderId;
        private String productName;
        private Double price;
        private String category;
        private String orderDate; // Định dạng đã chuyển thành String
        private Integer quantity;
        private Double totalAmount;

        // Các getter và setter
        public Long getOrderId() { return orderId; }
        public void setOrderId(Long orderId) { this.orderId = orderId; }

        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }

        public Double getPrice() { return price; }
        public void setPrice(Double price) { this.price = price; }

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        public String getOrderDate() { return orderDate; }
        public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }

        public Double getTotalAmount() { return totalAmount; }
        public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    }

