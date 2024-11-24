package com.rodua.basic_rest_api_example.service.user;

import com.rodua.basic_rest_api_example.dto.user.UserCreateRequest;
import com.rodua.basic_rest_api_example.dto.user.UserOutputDto;
import com.rodua.basic_rest_api_example.dto.user.UserPasswordUpdateRequest;

import java.util.List;

public interface UserService {
    List<UserOutputDto> findAll();
    UserOutputDto findById(Long id);
    UserOutputDto create(UserCreateRequest request);
    void updatePassword(UserPasswordUpdateRequest request);
    void deleteById(Long id);
}
