package model;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private int customerId;
    private LocalDate orderDate;
    private String orderStatus;
    private double totalAmount;
    private int productId;
    private int orderStatusId;

    public Order(int id, int customerId, LocalDate orderDate, int orderStatusId, double totalAmount) {
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
    public Order(int orderId, int customerId, LocalDate orderDate, int orderStatusId, double totalAmount, int productId) {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int getProductId) {
        this.productId = productId;
    }

    public Order(int orderId, int customerId, LocalDate orderDate, String orderStatus, double totalAmount, int getProductId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.productId = productId;
    }

    public Order() {
    }

    public Order(int orderId, int customerId, LocalDate orderDate, String orderStatus, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
    }

    public Order(int id, String customerName, String orderDetails, double totalAmount) {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
