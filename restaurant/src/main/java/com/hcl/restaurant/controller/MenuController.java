package com.hcl.restaurant.controller;

import com.hcl.restaurant.entity.MenuCategory;
import com.hcl.restaurant.entity.MenuItem;
import com.hcl.restaurant.entity.Restaurant;
import com.hcl.restaurant.repo.MenuCategoryRepo;
import com.hcl.restaurant.repo.MenuItemRepo;
import com.hcl.restaurant.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.hcl.restaurant.constant.ApiEndpoints.BASE_URI;

@RestController
@RequestMapping(BASE_URI)
public class MenuController {

    private RestaurantRepo restaurantRepo;
    private MenuCategoryRepo menuCategoryRepo;
    private MenuItemRepo menuItemRepo;

    @Autowired
    MenuController(
            RestaurantRepo restaurantRepo,
            MenuCategoryRepo menuCategoryRepo,
            MenuItemRepo menuItemRepo
    ) {
        this.restaurantRepo = restaurantRepo;
        this.menuCategoryRepo = menuCategoryRepo;
        this.menuItemRepo = menuItemRepo;
    }

    @GetMapping("/{restaurantId}/menucategories")
    public List<MenuCategory> menuCategories(@PathVariable("restaurantId") Long restaurantId) {
        getRestaurant(restaurantId);
        return menuCategoryRepo.findAllByRestaurantId(restaurantId);
    }

    @PostMapping("/{restaurantId}/menucategories")
    public ResponseEntity<String> menuCategories(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestBody Set<MenuCategory> menuCategories) {
        Restaurant restaurant = getRestaurant(restaurantId);

        menuCategories.forEach(
                menuCategory -> {
                    menuCategory.setRestaurant(restaurant);
                    menuCategoryRepo.save(menuCategory);
                }
        );

        return ResponseEntity.ok("Created Successfully!");
    }

    @GetMapping("/{restaurantId}/menucategories/{categoryId}/menuitems")
    public Set<MenuItem> menuItems(
            @PathVariable("restaurantId") Long restaurantId,
            @PathVariable("categoryId") Long categoryId) {
        getRestaurant(restaurantId);
        return menuItemRepo.findAllByMenuCategory(menuCategory(categoryId));
    }

    @PostMapping("/{restaurantId}/menucategories/{categoryId}/menuitems")
    public ResponseEntity<String> menuItems(
            @PathVariable("restaurantId") Long restaurantId,
            @PathVariable("categoryId") Long categoryId,
            @RequestBody List<MenuItem> menuItems) {
        getRestaurant(restaurantId);
        MenuCategory menuCategory = menuCategory(categoryId);

        menuItems.forEach(
                menuItem ->  {
                    menuItem.setMenuCategory(menuCategory);
                    menuItemRepo.save(menuItem);
                }
        );

        return ResponseEntity.ok("Created Successfully");
    }

    private MenuCategory menuCategory(Long categoryId) {
        if (categoryId <= 0) {
            throw new IllegalArgumentException("Not a valid menu category id");
        }
        MenuCategory menuCategory = menuCategoryRepo.findByCategoryId(categoryId);
        if (Objects.isNull(menuCategory)) {
            throw new IllegalArgumentException("MenuCategory did not found");
        }
        return menuCategory;
    }

    private Restaurant getRestaurant(Long restaurantId) {
        if (restaurantId <= 0) {
            throw new IllegalArgumentException("Not a valid restaurant id");
        }

        Restaurant restaurant = restaurantRepo.findByRestaurantId(restaurantId);

        if (Objects.isNull(restaurant)) {
            throw new IllegalArgumentException("Restaurant did not found");
        }
        return restaurant;
    }

}
