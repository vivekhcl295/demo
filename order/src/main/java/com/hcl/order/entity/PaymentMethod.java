package com.hcl.order.entity;

public enum PaymentMethod {
    CC("CREDIT_CARD"), DB("DEBIT_CARD"), NB("NET_BANKING");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public static PaymentMethod fromValue(String value) {
        if (value != null) {
            for (PaymentMethod pm : values()) {
                if (pm.value.equals(value)) {
                    return pm;
                }
            }
        }

        // you may return a default value
        return CC;
        // or throw an exception
        // throw new IllegalArgumentException("Invalid color: " + value);
    }

    public String toString() {
        return value;
    }
}
