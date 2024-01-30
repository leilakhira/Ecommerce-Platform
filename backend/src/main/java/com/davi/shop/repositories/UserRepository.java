package com.davi.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davi.shop.entities.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    Optional<User> findByEmail(String email);
}
