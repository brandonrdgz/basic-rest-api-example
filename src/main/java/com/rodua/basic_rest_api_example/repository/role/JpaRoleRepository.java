package com.rodua.basic_rest_api_example.repository.role;

import com.rodua.basic_rest_api_example.model.Role;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(@NotNull String name);
}
