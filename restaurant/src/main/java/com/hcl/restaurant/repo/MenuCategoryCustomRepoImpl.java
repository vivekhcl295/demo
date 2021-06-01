package com.hcl.restaurant.repo;

import com.hcl.restaurant.entity.MenuCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MenuCategoryCustomRepoImpl implements MenuCategoryCustomRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MenuCategory> findAllByRestaurantId(Long restaurantId) {
        Query query = entityManager.createNativeQuery("SELECT mc.* FROM restaurant.menu_categories as mc " +
                "WHERE mc.restaurant_id = ?", MenuCategory.class);
        query.setParameter(1, restaurantId);

        return query.getResultList();
    }
}
