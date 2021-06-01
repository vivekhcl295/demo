package com.hcl.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name= "payment")
public class Payment extends Audit {
    private Long paymentId;
    @Pattern(
       regexp = "CC|NB|DB",
       flags = Pattern.Flag.CASE_INSENSITIVE,
       message = "CC(Credit Card), NB(Net Banking), DB(Debit Card) only accepted currently."
    )
    private PaymentMethod paymentMethod;
    @Pattern(
       regexp = "[0-9]?[0-9]?(\\.[0-9][0-9]?)?"
    )
    private Double paymentAmount;
    private OrderEntity orderEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getPaymentId() {
        return paymentId;
    }

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    public OrderEntity getOrder() {
        return orderEntity;
    }

    public void setOrder(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
