package com.hcl.restaurant.repo;

import com.hcl.restaurant.entity.MenuCategory;
import com.hcl.restaurant.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
    Set<MenuItem> findAllByMenuCategory(MenuCategory menuCategory);
}
