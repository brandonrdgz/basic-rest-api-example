package com.rodua.basic_rest_api_example.service.authentication;

public interface JwtService {
    String generateAuthenticationToken(String username);
    String usernameFromToken(String token);
    boolean isTokenValid(String token);
}
