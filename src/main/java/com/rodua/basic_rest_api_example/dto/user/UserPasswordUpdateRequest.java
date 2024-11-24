package com.rodua.basic_rest_api_example.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPasswordUpdateRequest {
    private Long id;

    @NotBlank
    private String oldPassword;

    @NotBlank
    private String newPassword;
}
