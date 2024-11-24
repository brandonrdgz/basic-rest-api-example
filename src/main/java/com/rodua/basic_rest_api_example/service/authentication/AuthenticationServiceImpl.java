package com.rodua.basic_rest_api_example.service.authentication;

import com.rodua.basic_rest_api_example.config.exception.InvalidCredentialsException;
import com.rodua.basic_rest_api_example.dto.authentication.LoginRequest;
import com.rodua.basic_rest_api_example.dto.authentication.LoginResponse;
import com.rodua.basic_rest_api_example.dto.user.UserDto;
import com.rodua.basic_rest_api_example.repository.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(
            JwtService jwtService,
            AuthenticationManager authenticationManager,
            UserRepository userRepository
    ) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public LoginResponse login(final LoginRequest request) {
        final var usrPassAuthToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );

        try {
            authenticationManager.authenticate(usrPassAuthToken);
        } catch (AuthenticationException e) {
            throw new InvalidCredentialsException(e.getMessage());
        }

        final var userFound = userRepository.findByUsername(request.getUsername());
        final var jwt = jwtService.generateAuthenticationToken(userFound.getUsername());

        return new LoginResponse(jwt);
    }

    @Override
    public UserDto authenticatedUser() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        final var username = authentication.getName();

        return userRepository.findByUsername(username);
    }
}
