package com.restaurant.RestaurantAPI.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.RestaurantAPI.model.Food;
import com.restaurant.RestaurantAPI.repository.FoodRepository;

import lombok.NonNull;

@Service
public class FoodService {
    
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> listarComidas(){
        return foodRepository.findAll()
            .stream()
            .collect(Collectors.toList());
    }

    public Food saveFood(@NonNull Food food){
        return foodRepository.save(food);
    }

    public Optional<Food> updateFood(Long id, Food food){
        return foodRepository.findById(id)
            .map(existingFood -> {
                existingFood.setTitle(food.getTitle());
                existingFood.setPrice(food.getPrice());
                existingFood.setImage(food.getImage());
                return foodRepository.save(existingFood);
            });
    }

    public Optional<Food> deleteFood(Long id){
        Optional<Food> food_to_be_deleted = foodRepository.findById(id);
        food_to_be_deleted.ifPresent(food -> foodRepository.delete(food));
        return food_to_be_deleted;
    }
}
