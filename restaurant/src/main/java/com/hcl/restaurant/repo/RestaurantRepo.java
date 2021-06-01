package com.hcl.restaurant.repo;

import com.hcl.restaurant.entity.Restaurant;
import com.hcl.restaurant.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    Restaurant findByRestaurantId(Long restaurantId);

    @Modifying
    @Query("UPDATE Restaurant r SET r.status = :status WHERE r.restaurantId = :restaurantId")
    int updateRestaurant(@Param("restaurantId") Long restaurantId, @Param("status") Status status);

}
