package com.hcl.order.mongo.document;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("orders")
public class Order {
    private ObjectId _id;

    private Long orderId;
    private Set<OrderItem> orderItems;
    private Double orderAmount;
    private Payment payment;
    private Long restaurantId;

    public Order() {}

    public Order(ObjectId _id, Long orderId, Set<OrderItem> orderItems, Double orderAmount, Payment payment) {
        this._id = _id;
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.orderAmount = orderAmount;
        this.payment = payment;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

}