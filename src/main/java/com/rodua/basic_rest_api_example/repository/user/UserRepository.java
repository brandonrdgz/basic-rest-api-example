package com.rodua.basic_rest_api_example.repository.user;

import com.rodua.basic_rest_api_example.dto.user.UserDto;

import java.util.List;

public interface UserRepository {
    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto findByUsername(String username);
    UserDto save(UserDto user);
    void deleteById(Long id);
}
