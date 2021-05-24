package com.hcl.order.mongo.document;

public enum PaymentMethods {
    CC("CREDIT_CARD"), DB("DEBIT_CARD"), NB("NET_BANKING");

    private final String value;

    PaymentMethods(String value) {
        this.value = value;
    }

    public static PaymentMethods fromValue(String value) {
        if (value != null) {
            for (PaymentMethods pm : values()) {
                if (pm.value.equals(value)) {
                    return pm;
                }
            }
        }

        // you may return a default value
        return getDefault();
        // or throw an exception
        // throw new IllegalArgumentException("Invalid color: " + value);
    }

    public String toValue() {
        return value;
    }

    public static PaymentMethods getDefault() {
        return CC;
    }
}
