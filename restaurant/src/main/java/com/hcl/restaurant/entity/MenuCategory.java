package com.hcl.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu_categories")
public class MenuCategory extends Audit {

    private Long categoryId;
    private String title;
    private Status status;
    private Set<MenuItem> menuItems = new HashSet<>();
    private Restaurant restaurant;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menuCategory")
    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
