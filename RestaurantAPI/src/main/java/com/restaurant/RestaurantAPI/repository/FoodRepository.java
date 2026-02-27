package com.restaurant.RestaurantAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.RestaurantAPI.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
