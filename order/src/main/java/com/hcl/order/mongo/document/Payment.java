package com.hcl.order.mongo.document;

public class Payment {
    private Long paymentId;
    private PaymentMethods paymentMethod;
    private Double paymentAmount;

    public Payment() {}

    public Payment(Long paymentId, PaymentMethods paymentMethod, Double paymentAmount) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentMethods getPaymentMethod(PaymentMethods cc) {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}