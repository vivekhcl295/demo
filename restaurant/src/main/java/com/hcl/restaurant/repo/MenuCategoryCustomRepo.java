package com.hcl.restaurant.repo;

import com.hcl.restaurant.entity.MenuCategory;

import java.util.List;

public interface MenuCategoryCustomRepo {

    List<MenuCategory> findAllByRestaurantId(Long restaurantId);

}
