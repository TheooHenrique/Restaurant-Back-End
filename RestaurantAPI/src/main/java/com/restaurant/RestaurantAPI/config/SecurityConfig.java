package com.restaurant.RestaurantAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable).cors(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                
                // Regra de Negócio: Qualquer um pode ver a documentação da API
                .requestMatchers(
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html").permitAll()
                
                // Regra de Negócio: Qualquer um pode ver os livros
                .requestMatchers(HttpMethod.GET, "/foods/**").permitAll()
                
                // Regra de Negócio: Só ADMIN pode alterar o banco
                .requestMatchers(HttpMethod.POST, "/foods/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/foods/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/foods/**").authenticated()
                
                // O resto exige login
                .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}