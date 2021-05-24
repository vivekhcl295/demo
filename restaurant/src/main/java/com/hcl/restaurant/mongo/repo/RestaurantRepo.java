package com.hcl.restaurant.mongo.repo;

import com.hcl.restaurant.mongo.document.Restaurant;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends MongoRepository<Restaurant, ObjectId> {
    List<Restaurant> findAll();
    Restaurant save(Restaurant restaurant);
}
