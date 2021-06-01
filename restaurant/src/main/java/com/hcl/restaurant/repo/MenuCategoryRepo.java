package com.hcl.restaurant.repo;

import com.hcl.restaurant.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface MenuCategoryRepo extends JpaRepository<MenuCategory, Long>, MenuCategoryCustomRepo {

    MenuCategory findByCategoryId(Long categoryId);
    List<MenuCategory> findAll();
    <S extends MenuCategory> List<S> saveAll(Iterable<S> entities);

    Optional<MenuCategory> findByTitle(String title);
//    @Query("select m from MenuCategory m where m.restaurantId = :restaurantId")
//    Set<MenuCategory> findAllByRestaurantId(Long restaurantId);
}
