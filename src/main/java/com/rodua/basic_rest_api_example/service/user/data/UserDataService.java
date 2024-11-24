package com.rodua.basic_rest_api_example.service.user.data;

import com.rodua.basic_rest_api_example.dto.user.data.UserDataCreateRequest;
import com.rodua.basic_rest_api_example.dto.user.data.UserDataDto;
import com.rodua.basic_rest_api_example.dto.user.data.UserDataUpdateRequest;

public interface UserDataService {
    UserDataDto findByUserId(Long userId);
    UserDataDto create(UserDataCreateRequest request);
    UserDataDto update(UserDataUpdateRequest request);
}
