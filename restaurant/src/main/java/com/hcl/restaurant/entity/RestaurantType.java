package com.hcl.restaurant.entity;

public enum RestaurantType {
    VEG("VEG"), NON_VEG("NON_VEG");

    private final String value;

    RestaurantType(String value) {
        this.value = value;
    }

    public static RestaurantType fromValue(String value) {
        if (value != null) {
            for (RestaurantType type: values()) {
                if (type.value.equals(value)) {
                    return type;
                }
            }
        }
        throw new IllegalArgumentException("Restaurant Type [" + value + "] not supported!");
    }

    @Override
    public String toString() {
        return this.value;
    }
}
