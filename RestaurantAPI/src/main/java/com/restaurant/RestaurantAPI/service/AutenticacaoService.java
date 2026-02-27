// package com.restaurant.RestaurantAPI.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.restaurant.RestaurantAPI.repository.UsersRepository;

// @Service
// public class AutenticacaoService implements UserDetailsService{
    
//     @Autowired
//     private UsersRepository usersRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//         return usersRepository.findByUsername(username)
//                 .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado" + username));
//     }
// }
