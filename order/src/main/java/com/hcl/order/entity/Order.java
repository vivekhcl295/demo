package com.hcl.order.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

import static com.hcl.order.constant.API_MESSAGES.PAYMENT_NOT_NULL;

@Entity
@Table(name="tbl_order")
@JsonPropertyOrder({
        "orderId", "customerId", "restaurantId" ,"orderStatus",
        "orderItems", "orderAmount", "payment"
})
@Validated
public class Order extends Audit {
    private Long orderId;
    @NotNull
    @Size(min = 1, message = "At least one order item is required")
    private Set<OrderItem> orderItems;
    @NotNull
    private Double orderAmount;
    @Null
    private OrderStatus orderStatus;
    @NotNull(message = PAYMENT_NOT_NULL)
    private Payment payment;
    @NotNull
    @Min(1)
    private Long restaurantId;
    @NotNull
    @Min(1)
    private Long customerId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
