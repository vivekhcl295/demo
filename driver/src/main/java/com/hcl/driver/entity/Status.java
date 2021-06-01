package com.hcl.driver.entity;

public enum Status {
    ONLINE("ONLLINE"), OFFLINE("OFFLINE");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public static Status fromValue(String value) {
        if (value != null) {
            for (Status status: values()) {
                if (status.value.equals(value)) {
                    return status;
                }
            }
        }

        // Returning default value
        return Status.OFFLINE;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
