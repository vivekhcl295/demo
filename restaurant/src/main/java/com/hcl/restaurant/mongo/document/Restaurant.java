package com.hcl.restaurant.mongo.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("restaurant")
public class Restaurant {
    @Id
    private ObjectId _id;
    private Long restaurantId;
    private String name;
    private String address;

    public Restaurant() {}

    public Restaurant(ObjectId _id, String name, String address) {
        this._id = _id;
        this.name = name;
        this.address = address;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
