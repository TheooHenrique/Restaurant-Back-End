package com.restaurant.RestaurantAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.RestaurantAPI.model.Food;
import com.restaurant.RestaurantAPI.service.FoodService;


@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    public FoodService foodService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Food>> listFood(){
        List<Food> list = foodService.listarComidas();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Food> saveFood(@RequestBody Food food){
        try {
            Food foodCadastrada = foodService.saveFood(food);
            if (foodCadastrada == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(food, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food){
        Optional<Food> updated_food = foodService.updateFood(id, food);
        
        if (updated_food.isPresent()){
            return new ResponseEntity<>(updated_food.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/update/delete/{id}")
    public ResponseEntity<Food> deleteFood(@PathVariable Long id){
        Optional<Food> deleted_food = foodService.deleteFood(id);

        if (deleted_food.isPresent()){
            return new ResponseEntity<>(deleted_food.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    
    
}
