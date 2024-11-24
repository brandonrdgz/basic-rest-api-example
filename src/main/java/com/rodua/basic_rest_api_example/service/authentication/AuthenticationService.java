package com.rodua.basic_rest_api_example.service.authentication;

import com.rodua.basic_rest_api_example.dto.authentication.LoginRequest;
import com.rodua.basic_rest_api_example.dto.authentication.LoginResponse;
import com.rodua.basic_rest_api_example.dto.user.UserDto;

public interface AuthenticationService {
    LoginResponse login(final LoginRequest request);
    UserDto authenticatedUser();
}
