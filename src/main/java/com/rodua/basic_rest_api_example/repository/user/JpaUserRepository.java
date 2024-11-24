package com.rodua.basic_rest_api_example.repository.user;

import com.rodua.basic_rest_api_example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
