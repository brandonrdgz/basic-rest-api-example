package com.rodua.basic_rest_api_example.repository.user.data;

import com.rodua.basic_rest_api_example.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserDataRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
