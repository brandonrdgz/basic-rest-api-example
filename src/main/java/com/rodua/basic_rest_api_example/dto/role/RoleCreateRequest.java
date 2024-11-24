package com.rodua.basic_rest_api_example.dto.role;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleCreateRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
