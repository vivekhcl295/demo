package com.hcl.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="order_items")
public class OrderItem extends Audit {
    private Integer itemId;
    @NotNull
    private String itemName;
    @Pattern(
            regexp = "[0-9]?[0-9]?(\\.[0-9][0-9]?)?"
    )
    private Double itemPrice;
    @Min(1)
    private Integer itemQty;
    private OrderEntity orderEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemQty() {
        return itemQty;
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    public OrderEntity getOrder() {
        return orderEntity;
    }

    public void setOrder(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
