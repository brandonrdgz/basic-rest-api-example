package com.rodua.basic_rest_api_example.controller.authentication;

import com.rodua.basic_rest_api_example.dto.authentication.LoginRequest;
import com.rodua.basic_rest_api_example.dto.authentication.LoginResponse;
import com.rodua.basic_rest_api_example.service.authentication.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid final LoginRequest request) {
        final var response = authenticationService.login(request);

        return ResponseEntity.ok(response);
    }
}
