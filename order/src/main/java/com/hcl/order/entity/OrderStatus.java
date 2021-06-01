package com.hcl.order.entity;

public enum OrderStatus {
    CREATE("CREATED"), IN_PROGRESS("IN_PROGRESS"),
    IN_TRANSIT("IN_TRANSIT"), COMPLETE("COMPLETED"),
    FAILED("FAILED");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public static OrderStatus fromValue(String value) {
        if (value != null) {
            for (OrderStatus status : values()) {
                if (status.value.equals(value)) {
                    return status;
                }
            }
        }

        // Returning default value
        return OrderStatus.FAILED;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
