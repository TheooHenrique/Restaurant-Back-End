package com.restaurant.RestaurantAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class LoginController {
    
    @PostMapping("/login")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("Login feito com sucesso!");
    }
}
