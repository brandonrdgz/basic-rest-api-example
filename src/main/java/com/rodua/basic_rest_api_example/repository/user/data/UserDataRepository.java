package com.rodua.basic_rest_api_example.repository.user.data;

import com.rodua.basic_rest_api_example.dto.user.data.UserDataDto;

public interface UserDataRepository {
    UserDataDto findByUserId(Long userId);
    UserDataDto save(UserDataDto user);
    void deleteByUserId(Long userId);
}
