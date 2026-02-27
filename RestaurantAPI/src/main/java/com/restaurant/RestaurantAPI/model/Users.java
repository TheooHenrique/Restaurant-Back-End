package com.restaurant.RestaurantAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


@Table(name = "users")
public class Users{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String senha;

    // @Transient
    // private String role = "USER";

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return List.of(new SimpleGrantedAuthority("ROLE_" + this.role));
    // }

    public Users(){}

    public Users(String username, String senha, String role) {
        this.username = username;
        this.senha = senha;
        // this.role = role;
    }

    // @Override
    // public String getPassword() {
    //     return this.senha;
    // }

    // @Override
    // public String getUsername() {
    //     return this.username;
    // }

    // @Override public boolean isAccountNonExpired() { return true; }
    // @Override public boolean isAccountNonLocked() { return true; }
    // @Override public boolean isCredentialsNonExpired() { return true; }
    // @Override public boolean isEnabled() { return true; }

}
